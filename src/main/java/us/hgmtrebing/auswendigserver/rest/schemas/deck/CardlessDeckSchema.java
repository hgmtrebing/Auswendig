package us.hgmtrebing.auswendigserver.rest.schemas.deck;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    // Side 01 Template Fields

    @Schema(description = "The name of Side 01 for the Deck.")
    private String side01Name;

    @Schema(description = "The description of Side 01 for the Deck.")
    private String side01Description;

    @Schema(description = "The datatype of Side 01 for the Deck.")
    private SideTypeSchema side01Type;

    @Schema(description = "A global hint for Side 01.")
    private String side01GlobalHint;

    @Schema(description = "A global note for Side 01.")
    private String side01GlobalNote;


    // Side 02 Template Fields

    @Schema(description = "The name of Side 02 for the Deck.")
    private String side02Name;

    @Schema(description = "The description of Side 02 for the Deck.")
    private String side02Description;

    @Schema(description = "The datatype of Side 02 for the Deck.")
    private SideTypeSchema side02Type;

    @Schema(description = "A global hint for Side 02.")
    private String side02GlobalHint;

    @Schema(description = "A global note for Side 02.")
    private String side02GlobalNote;

}
