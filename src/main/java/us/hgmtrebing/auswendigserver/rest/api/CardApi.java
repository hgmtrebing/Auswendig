package us.hgmtrebing.auswendigserver.rest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import us.hgmtrebing.auswendigserver.rest.schemas.HttpApiResponse;
import us.hgmtrebing.auswendigserver.rest.schemas.deck.CardSchema;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/card")
@Tag(name = "Card Controller", description = "RESTful API for administering Auswendig Cards.")
public interface CardApi {

    @GetMapping("get-all-card")
    @Operation(summary = "Get All Cards.", description = "Get All Cards in the System.")
    public abstract HttpApiResponse<List<CardSchema>> getAllCards();

    @GetMapping("get-cards-by-deck")
    @Operation(summary = "Get All Cards by Deck.", description = "Get All Cards for a given deck.")
    public abstract HttpApiResponse<List<CardSchema>> getAllDeckCards(UUID deckId);

    @PostMapping("add-card")
    @Operation(summary = "Add Card.", description = "Adds a new Card into the System.")
    public abstract HttpApiResponse<CardSchema> addCard(@RequestBody CardSchema card);

    @PutMapping("add-card")
    @Operation(summary = "Update Card.", description = "Updates an existing Card in the System.")
    public abstract HttpApiResponse<CardSchema> updateCard(@RequestBody CardSchema card);
}
