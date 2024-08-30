package us.hgmtrebing.auswendigserver.rest.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;
import us.hgmtrebing.auswendigserver.database.repository.CardlessDeckRepository;
import us.hgmtrebing.auswendigserver.rest.api.DeckApi;
import us.hgmtrebing.auswendigserver.rest.mapping.DeckMapper;
import us.hgmtrebing.auswendigserver.rest.schemas.CardlessDeckSchema;
import us.hgmtrebing.auswendigserver.rest.schemas.HttpApiResponse;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class DeckController implements DeckApi {

    private DeckMapper deckMapper;
    private CardlessDeckRepository cardlessDeckRepository;

    @Override
    public HttpApiResponse<List<CardlessDeckSchema>> getAllDecksCardless() {
        var cards = deckMapper.convert(cardlessDeckRepository.findAll());
        return HttpApiResponse.passedFully(cards);
    }
}
