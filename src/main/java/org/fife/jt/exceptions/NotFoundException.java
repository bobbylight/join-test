package org.fife.jt.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractRestException {

    public NotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}
