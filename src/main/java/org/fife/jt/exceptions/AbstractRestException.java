package org.fife.jt.exceptions;

import org.springframework.http.HttpStatus;

abstract class AbstractRestException extends RuntimeException {

    private HttpStatus status;

    AbstractRestException(HttpStatus status) {
        this(status, null);
    }

    AbstractRestException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    HttpStatus getStatus() {
        return status;
    }
}
