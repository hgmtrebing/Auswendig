package us.hgmtrebing.auswendigserver.rest.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import us.hgmtrebing.auswendigserver.rest.exception.DeckAlreadyExistsException;
import us.hgmtrebing.auswendigserver.rest.exception.FailedToFindUserException;
import us.hgmtrebing.auswendigserver.rest.schemas.ApiResponse;
import us.hgmtrebing.auswendigserver.rest.schemas.HttpApiResponse;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(FailedToFindUserException.class)
    public ResponseEntity<ApiResponse<String>> handleFailedToFindUserException(FailedToFindUserException e) {
        String msg = "Failed to find user: " + e.getUsername();
        log.error(msg, e);
        return ResponseEntity.badRequest().body(
                ApiResponse.failedCompletely(null, msg)
        );
    }

    @ExceptionHandler(DeckAlreadyExistsException.class)
    public HttpApiResponse<String> handle(DeckAlreadyExistsException e) {
        log.error(e.getMessage(), e);
        return HttpApiResponse.badRequest(e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception e) {
        String msg = "An unexpected error occurred: " + e.toString();
        log.error(msg, e);
        return ResponseEntity.internalServerError().body(
                ApiResponse.failedCompletely(null, msg)
        );

    }
}
