package org.fife.jt.rest;

import org.fife.jt.exceptions.NotFoundException;
import org.fife.jt.model.Parent;
import org.fife.jt.services.ParentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ParentController.class);

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Parent>> getAll(@RequestParam(required = false) Long parentId,
                                        @RequestParam(required = false) Integer childValue) {

        List<Parent> parents;

        if (parentId != null || childValue != null) {
            LOGGER.debug("Request to get all Parents with a child with value: {}", childValue);
            parents = parentService.getAllWithFiltering(parentId, childValue);
        }
        else {
            LOGGER.debug("Request to get all Parents");
            parents = parentService.getAll();
        }

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
}
