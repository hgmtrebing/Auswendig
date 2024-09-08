package us.hgmtrebing.auswendigserver.rest.schemas.deck;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Schema to encapsulate deck data (without cards).")
public class CardlessDeckSchema {

    @Schema(description = "The System Identifier for this deck.")
    private UUID externalId;

    @Schema(description = "The name of the given deck.", example = "German-to-English Vocabulary")
    private String deckName;

    @Schema(description = "The description of the given deck.", example = "Deck of English and German Vocabulary.")
    private String deckDescription;

    @Schema(description = "The username of the deck's owner.", example = "orabbit")
    private String ownerUsername;

    @Schema(description = "A global hint for all cards and sides.")
    private String globalHint;

    @Schema(description = "A global note for all cards and sides.")
    private String globalNote;

    @Schema(description = "The name for the question side.")
    private String questionSideName;

    @Schema(description = "The name for the answer side.")
    private String answerSideName;

    @Schema(description = "The total success count for this deck.")
    private Long successCount;

    @Schema(description = "The total failure count for this deck.")
    private Long failureCount;

    @Schema(description = "The last success date for this deck.")
    private LocalDateTime lastSuccess;

    @Schema(description = "The last failure date for this deck.")
    private LocalDateTime lastFailure;

}
