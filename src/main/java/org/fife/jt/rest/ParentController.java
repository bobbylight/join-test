package org.fife.jt.rest;

import org.fife.jt.exceptions.NotFoundException;
import org.fife.jt.model.Parent;
import org.fife.jt.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Parent>> getAll() {
        List<Parent> parents = parentService.getAll();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    ResponseEntity<Parent> getParent(@PathVariable long id) {

        Parent parent = parentService.getParent(id);
        if (parent == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<>(parent, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/filteredByChildId/{childId}")
    ResponseEntity<List<Parent>> queryOnChildField(@PathVariable long childId) {
        List<Parent> parents = parentService.getAllContainingChildWithId(childId);
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }
}
