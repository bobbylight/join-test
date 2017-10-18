package org.fife.jt.repositories;

import org.fife.jt.model.Parent;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ParentRepository extends CrudRepository<Parent, Long>, QueryDslPredicateExecutor<Parent> {

}
