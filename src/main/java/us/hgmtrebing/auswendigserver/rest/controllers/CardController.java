package us.hgmtrebing.auswendigserver.rest.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;
import us.hgmtrebing.auswendigserver.database.repository.CardRepository;
import us.hgmtrebing.auswendigserver.database.repository.CardlessDeckRepository;
import us.hgmtrebing.auswendigserver.rest.api.CardApi;
import us.hgmtrebing.auswendigserver.rest.exception.CardAlreadyExistsException;
import us.hgmtrebing.auswendigserver.rest.exception.CardDoesNotExistException;
import us.hgmtrebing.auswendigserver.rest.exception.DeckDoesNotExistException;
import us.hgmtrebing.auswendigserver.rest.mapping.CardMapper;
import us.hgmtrebing.auswendigserver.rest.schemas.HttpApiResponse;
import us.hgmtrebing.auswendigserver.rest.schemas.deck.CardSchema;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
public class CardController implements CardApi {

    private CardMapper cardMapper;
    private CardRepository cardRepository;
    private CardlessDeckRepository deckRepository;

    @Override
    public HttpApiResponse<CardSchema> addCard(CardSchema card) {
        if (cardRepository.findFirstByExternalId(card.getCardExternalId()) != null) {
            throw new CardAlreadyExistsException(card.getCardExternalId());
        }

        CardlessDeckEntity deck = deckRepository.findFirstByExternalId(card.getDeckExternalId());
        if (deck == null) {
            throw new DeckDoesNotExistException(card.getDeckExternalId());
        }

        var result = cardRepository.saveAndFlush(cardMapper.convert(card, deck));
        return HttpApiResponse.passedFully(cardMapper.convert(result));
    }

    @Override
    public HttpApiResponse<List<CardSchema>> getAllCards() {
        return HttpApiResponse.passedFully(cardMapper.convert(cardRepository.findAll()));
    }

    @Override
    public HttpApiResponse<List<CardSchema>> getAllDeckCards(UUID deckId) {
        CardlessDeckEntity deck = deckRepository.findFirstByExternalId(deckId);

        if (deck == null) {
            throw new DeckDoesNotExistException(deckId);
        }

        return HttpApiResponse.passedFully(cardMapper.convert(cardRepository.findAllByDeck(deck)));
    }

    @Override
    public HttpApiResponse<CardSchema> updateCard(CardSchema card) {
        CardEntity cardEntity = cardRepository.findFirstByExternalId(card.getCardExternalId());
        if (cardEntity == null) {
            throw new CardDoesNotExistException(card.getCardExternalId());
        }

        CardlessDeckEntity deckEntity = deckRepository.findFirstByExternalId(card.getDeckExternalId());
        if (deckEntity == null) {
            throw new DeckDoesNotExistException(card.getDeckExternalId());
        }

        var result = cardRepository.saveAndFlush(cardMapper.update(cardEntity, card, deckEntity));
        return HttpApiResponse.passedFully(cardMapper.convert(result));
    }
}
