package us.hgmtrebing.auswendigserver.rest.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Schema to encapsulate deck data (without cards).")
public class CardlessDeckSchema {

    @Schema(description = "The name of the given deck.", example = "German-to-English Vocabulary")
    private String deckName;

    @Schema(description = "The description of the given deck.", example = "Deck of English and German Vocabulary.")
    private String deckDescription;

    @Schema(description = "The username of the deck's owner.", example = "orabbit")
    private String ownerUsername;
}
