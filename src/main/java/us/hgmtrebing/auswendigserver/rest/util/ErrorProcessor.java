package us.hgmtrebing.auswendigserver.rest.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.rest.schemas.OperationStatus;
import us.hgmtrebing.auswendigserver.rest.schemas.RequestResponse;

@Slf4j
@Service
public class ErrorProcessor {

    public <T> RequestResponse<T> addErrorAndLog(String errorMessage, RequestResponse<T> response) {
        log.error(errorMessage);
        response.addOperationResponse(OperationStatus.FAILED_COMPLETELY, errorMessage);
        return response;
    }

    public <T> RequestResponse<T> addErrorAndLog(String errorMessage, Exception e, RequestResponse<T> response) {
        errorMessage += e.toString();
        log.error(errorMessage, e);
        response.addOperationResponse(OperationStatus.FAILED_COMPLETELY, errorMessage);
        return response;
    }
}
