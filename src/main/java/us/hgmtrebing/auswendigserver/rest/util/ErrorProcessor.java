package us.hgmtrebing.auswendigserver.rest.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.rest.schemas.ApiResponse;

@Slf4j
@Service
public class ErrorProcessor {

    public <T> ApiResponse<T> addErrorAndLog(String errorMessage, ApiResponse<T> response) {
        log.error(errorMessage);
        response.addError(errorMessage);
        return response;
    }

    public <T> ApiResponse<T> addErrorAndLog(String errorMessage, Exception e, ApiResponse<T> response) {
        errorMessage += e.toString();
        log.error(errorMessage, e);
        response.addError(errorMessage);
        return response;
    }

    public <T> ApiResponse<T> createErrorResponse(String errorMessage, Exception e) {
        return addErrorAndLog(errorMessage, e, ApiResponse.failedCompletely(null));
    }

    public <T> ApiResponse<T> createErrorResponse(String errorMessage) {
        return addErrorAndLog(errorMessage, ApiResponse.failedCompletely(null));
    }
}
