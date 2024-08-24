package us.hgmtrebing.auswendigserver.rest.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import us.hgmtrebing.auswendigserver.rest.exception.FailedToFindUserException;
import us.hgmtrebing.auswendigserver.rest.schemas.OperationResponse;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(FailedToFindUserException.class)
    public ResponseEntity<OperationResponse<String>> handleFailedToFindUserException(FailedToFindUserException e) {
        String msg = "Failed to find user: " + e.getUsername();
        log.error(msg, e);
        return ResponseEntity.badRequest().body(
                OperationResponse.failedCompletely(null, msg)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<OperationResponse<String>> handleException(Exception e) {
        String msg = "An unexpected error occurred: " + e.toString();
        log.error(msg, e);
        return ResponseEntity.internalServerError().body(
                OperationResponse.failedCompletely(null, msg)
        );

    }
}
