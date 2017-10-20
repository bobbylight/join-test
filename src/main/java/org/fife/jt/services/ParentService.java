package org.fife.jt.services;

import com.querydsl.jpa.impl.JPAQuery;
import org.fife.jt.model.Parent;
import org.fife.jt.model.QOneToOneChild;
import org.fife.jt.model.QParent;
import org.fife.jt.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Parent> getAll() {
        Iterable<Parent> parents = parentRepository.findAll();
        List<Parent> parentList = new ArrayList<>();
        parents.forEach(parentList::add);
        return parentList;
    }

    public List<Parent> getAllWithFiltering(Long parentId, Integer childValue) {

        QParent parent = QParent.parent;
        JPAQuery<Parent> query = new JPAQuery<>(entityManager);

        // Ensure we query with a left join
        query = query.from(parent)
            .leftJoin(parent.oneToOneChild, QOneToOneChild.oneToOneChild);

        if (parentId != null) {
            query = query.where(parent.id.eq(parentId));
        }
        if (childValue != null) {
            query = query.where(parent.oneToOneChild.value.eq(childValue));
        }

        List<Parent> matches = query.fetch();
        return matches;
    }

    public Parent getParent(long id) {
        return parentRepository.findOne(id);
    }
}
