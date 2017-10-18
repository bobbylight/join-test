package org.fife.jt.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(AbstractRestException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> notFound(HttpServletRequest request, AbstractRestException e) {
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(e.getStatus().value());
        return new ResponseEntity<>(response, e.getStatus());
    }
}
