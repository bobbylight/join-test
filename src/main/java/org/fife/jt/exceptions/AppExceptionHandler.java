package org.fife.jt.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Overridden to return our custom error JSON.
     *
     * @param e The exception thrown.
     * @param body The body of the response.  This parameter is ignored.
     * @param headers Any headers for the response.
     * @param status The status for the response.
     * @param request The request.
     * @return The response entity to return.
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception e, Object body,
                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse(status.value(), e.getMessage());
        return new ResponseEntity<>(response, headers, status);
    }

    @ExceptionHandler(AbstractRestException.class)
    public ResponseEntity<Object> notFound(WebRequest request, AbstractRestException e) {
        return handleExceptionInternal(e, null, null, e.getStatus(), request);
    }
}
