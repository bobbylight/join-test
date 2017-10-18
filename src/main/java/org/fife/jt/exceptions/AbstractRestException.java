package org.fife.jt.exceptions;

import org.springframework.http.HttpStatus;

abstract class AbstractRestException extends RuntimeException {

    private HttpStatus status;

    AbstractRestException(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
