package us.hgmtrebing.auswendigserver.rest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import us.hgmtrebing.auswendigserver.rest.schemas.CardlessDeckSchema;
import us.hgmtrebing.auswendigserver.rest.schemas.HttpApiResponse;
import us.hgmtrebing.auswendigserver.rest.schemas.UserSchema;

import java.util.List;

@RequestMapping("/api/v1/deck")
@Tag(name = "Deck Controller", description = "RESTful API for Auswendig Decks.")
public interface DeckApi {

    @GetMapping("get-all-cardless-decks")
    @Operation(summary = "Get All Cardless Decks.", description = "Get All Cardless Decks in the System.")
    public abstract HttpApiResponse<List<CardlessDeckSchema>> getAllDecksCardless();

    @PostMapping("add-cardless-deck")
    @Operation(summary = "Add a Cardless Deck.", description = "Add a new Cardless Deck to the System.")
    public abstract HttpApiResponse<CardlessDeckSchema> addCardlessDeck(@RequestBody CardlessDeckSchema schema);

    @PutMapping("update-cardless-deck")
    @Operation(summary = "Update Cardless Deck.", description = "Updates a pre-existing Cardless Deck in the Systm.")
    public abstract HttpApiResponse<CardlessDeckSchema> updateCardlessDeck(@RequestBody CardlessDeckSchema schema);
}
