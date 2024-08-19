package us.hgmtrebing.auswendigserver.rest.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Schema(description = "Response Data to an API Request.")
public class OperationResponse<T> {

    @Schema(description = "Statuses of individual operations.")
    private List<String> errorMessages = new ArrayList<>();

    @Getter
    @Schema(description = "Master \"rollup\" status for all of the operations.")
    private OperationStatus rollupStatus = OperationStatus.UNKNOWN;

    @Getter
    @Schema(description = "The actual data returned by the endpoint, if any.")
    private T data = null;

    public OperationResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public OperationResponse<T> addError(String errorMessage) {
        this.errorMessages.add(errorMessage);
        return this;
    }

    public OperationResponse<T> addErrors(String ... errorMessages) {
        this.errorMessages.addAll(Arrays.asList(errorMessages));
        return this;
    }

    public List<String> getErrors() {
        return new ArrayList<>(this.errorMessages);
    }

    public boolean hasErrors() {
        return !this.errorMessages.isEmpty();
    }

    public OperationResponse<T> setStatus(OperationStatus status) {
        this.rollupStatus = status;
        return this;
    }

    public OperationResponse<T> mergeStatus(OperationStatus status) {
        this.rollupStatus = OperationStatus.merge(this.rollupStatus, status);
        return this;
    }

    public static <T> OperationResponse<T> of(T data, OperationStatus status, String ... errorMessages) {
        return new OperationResponse<T>()
                .setData(data)
                .setStatus(status)
                .addErrors(errorMessages);
    }

    public static <T> OperationResponse<T> failedCompletely(T data, String ... errorMessages) {
        return of(data, OperationStatus.FAILED_COMPLETELY, errorMessages);
    }

    public static <T> OperationResponse<T> passedWithErrors(T data, String ... errorMessages) {
        return of(data, OperationStatus.PASSED_WITH_ERRORS, errorMessages);
    }

    public static <T> OperationResponse<T> passedCompletely(T data, String ... errorMessages) {
        return of(data, OperationStatus.PASSED_COMPLETELY, errorMessages);
    }
}
