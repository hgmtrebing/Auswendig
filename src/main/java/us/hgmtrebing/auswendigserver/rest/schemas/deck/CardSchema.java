package us.hgmtrebing.auswendigserver.rest.schemas.deck;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "A schema to encapsulate card data.")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardSchema {

    @Schema(description = "The identifer for this Card.")
    private UUID cardExternalId;

    @Schema(description = "The identifier for the deck that owns this card.")
    private UUID deckExternalId;

    // Side 01 Fields

    @Schema(description = "The value of Side 01.")
    private String side01Value;

    @Schema(description = "The note on Side 01.")
    private String side01Note;

    @Schema(description = "The hint for Side 01.")
    private String side01Hint;

    @Schema(description = "The success count for Side 01.")
    private Long side01SuccessCount;

    @Schema(description = "The failure count for Side 01.")
    private Long side01FailureCount;

    @Schema(description = "The last success date for Side 01.")
    private LocalDateTime side01LastSuccess;

    @Schema(description = "The last failure date for Side 01.")
    private LocalDateTime side01LastFailure;


    // Side 02 Fields

    @Schema(description = "The value of Side 01.")
    private String side02Value;

    @Schema(description = "The note on Side 01.")
    private String side02Note;

    @Schema(description = "The hint for Side 01.")
    private String side02Hint;

    @Schema(description = "The success count for Side 01.")
    private Long side02SuccessCount;

    @Schema(description = "The failure count for Side 01.")
    private Long side02FailureCount;

    @Schema(description = "The last success date for Side 01.")
    private LocalDateTime side02LastSuccess;

    @Schema(description = "The last failure date for Side 01.")
    private LocalDateTime side02LastFailure;
}
