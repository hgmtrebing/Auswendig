package us.hgmtrebing.auswendigserver.rest.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response from an individual, atomic operation.")
public class OperationResponse {

    @Schema(description = "Status of an individual, atomic operation.")
    private OperationStatus status = OperationStatus.UNKNOWN;

    @Schema(description = "Error message returned by the operation, if any.")
    private String errorMessage = null;

}
