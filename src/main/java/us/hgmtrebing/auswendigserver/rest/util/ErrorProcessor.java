package us.hgmtrebing.auswendigserver.rest.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.rest.schemas.OperationStatus;
import us.hgmtrebing.auswendigserver.rest.schemas.OperationResponse;

@Slf4j
@Service
public class ErrorProcessor {

    public <T> OperationResponse<T> addErrorAndLog(String errorMessage, OperationResponse<T> response) {
        log.error(errorMessage);
        response.addError(errorMessage);
        return response;
    }

    public <T> OperationResponse<T> addErrorAndLog(String errorMessage, Exception e, OperationResponse<T> response) {
        errorMessage += e.toString();
        log.error(errorMessage, e);
        response.addError(errorMessage);
        return response;
    }

    public <T> OperationResponse<T> createErrorResponse(String errorMessage, Exception e) {
        return addErrorAndLog(errorMessage, e, OperationResponse.failedCompletely(null));
    }

    public <T> OperationResponse<T> createErrorResponse(String errorMessage) {
        return addErrorAndLog(errorMessage, OperationResponse.failedCompletely(null));
    }
}
