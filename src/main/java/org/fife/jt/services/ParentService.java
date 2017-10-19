package org.fife.jt.services;

import org.fife.jt.model.Parent;
import org.fife.jt.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public List<Parent> getAll() {
        Iterable<Parent> parents = parentRepository.findAll();
        List<Parent> parentList = new ArrayList<>();
        parents.forEach(parentList::add);
        return parentList;
    }

    public List<Parent> getAllContainingChildWithId(long childId) {
        return null;
    }

    public Parent getParent(long id) {
        return parentRepository.findOne(id);
    }
}
