package us.hgmtrebing.auswendigserver.rest.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Schema(description = "Response Data to an API Request.")
public class ApiResponse<T> {

    @Schema(description = "Statuses of individual operations.")
    private List<String> errorMessages = new ArrayList<>();

    @Getter
    @Schema(description = "Master \"rollup\" status for all of the operations.")
    private ApiStatus rollupStatus = ApiStatus.UNKNOWN;

    @Getter
    @Schema(description = "The actual data returned by the endpoint, if any.")
    private T data = null;

    public ApiResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public ApiResponse<T> addError(String errorMessage) {
        this.errorMessages.add(errorMessage);
        return this;
    }

    public ApiResponse<T> addErrors(String ... errorMessages) {
        this.errorMessages.addAll(Arrays.asList(errorMessages));
        return this;
    }

    public List<String> getErrors() {
        return new ArrayList<>(this.errorMessages);
    }

    public boolean hasErrors() {
        return !this.errorMessages.isEmpty();
    }

    public ApiResponse<T> setStatus(ApiStatus status) {
        this.rollupStatus = status;
        return this;
    }

    public ApiResponse<T> mergeStatus(ApiStatus status) {
        this.rollupStatus = ApiStatus.merge(this.rollupStatus, status);
        return this;
    }

    public static <T> ApiResponse<T> of(T data, ApiStatus status, String ... errorMessages) {
        return new ApiResponse<T>()
                .setData(data)
                .setStatus(status)
                .addErrors(errorMessages);
    }

    public static <T> ApiResponse<T> failedCompletely(T data, String ... errorMessages) {
        return of(data, ApiStatus.FAILED_COMPLETELY, errorMessages);
    }

    public static <T> ApiResponse<T> passedWithErrors(T data, String ... errorMessages) {
        return of(data, ApiStatus.PASSED_WITH_ERRORS, errorMessages);
    }

    public static <T> ApiResponse<T> passedCompletely(T data, String ... errorMessages) {
        return of(data, ApiStatus.PASSED_COMPLETELY, errorMessages);
    }
}
