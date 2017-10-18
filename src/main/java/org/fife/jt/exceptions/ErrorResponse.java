package org.fife.jt.exceptions;

/**
 * Returned to the user when an error occurs (any 4xx or 5xx response).
 */
public class ErrorResponse {

    private int statusCode;

    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
