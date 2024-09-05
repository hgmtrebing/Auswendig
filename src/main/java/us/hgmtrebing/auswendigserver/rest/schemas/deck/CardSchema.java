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

    @Schema(description = "The question for this card.")
    private String question;

    @Schema(description = "The answer for this card.")
    private String answer;

    @Schema(description = "The note for this card.")
    private String note;

    @Schema(description = "The hint for this card.")
    private String hint;

    @Schema(description = "The success count for this code.")
    private Long successCount;

    @Schema(description = "The failure count for this card.")
    private Long failureCount;

    @Schema(description = "The last success date for this card.")
    private LocalDateTime lastSuccess;

    @Schema(description = "The last failure date for this card.")
    private LocalDateTime lastFailure;
}
