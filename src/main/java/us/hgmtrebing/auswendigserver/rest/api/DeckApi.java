package us.hgmtrebing.auswendigserver.rest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
