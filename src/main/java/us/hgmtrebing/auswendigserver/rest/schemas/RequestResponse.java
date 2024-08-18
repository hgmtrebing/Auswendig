package us.hgmtrebing.auswendigserver.rest.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Schema(description = "Response Data to an API Request.")
public class RequestResponse<T> {

    @Getter
    @Schema(description = "Statuses of individual operations.")
    private List<OperationResponse> operationResponses = new ArrayList<>();

    @Getter
    @Schema(description = "Master \"rollup\" status for all of the operations.")
    private OperationStatus rollupStatus = OperationStatus.UNKNOWN;

    @Getter @Setter
    @Schema(description = "The actual data returned by the endpoint, if any.")
    private T data = null;


    public RequestResponse<T> addOperationResponse(OperationStatus status, String errorMessage) {
        return this.addOperationResponse(OperationResponse.builder()
                .status(status)
                .errorMessage(errorMessage)
                .build()
        );
    }

    public RequestResponse<T> addOperationResponse(OperationResponse response) {
        this.operationResponses.add(response);
        this.rollupStatus = OperationStatus.merge(this.rollupStatus, response.getStatus());

        return this;
    }

    public RequestResponse<T> mergeOperationResponses(RequestResponse<?> other) {
        for (OperationResponse response : other.getOperationResponses()) {
            this.addOperationResponse(response);
        }

        return this;
    }

}
