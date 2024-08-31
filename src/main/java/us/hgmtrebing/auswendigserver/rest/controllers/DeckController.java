package us.hgmtrebing.auswendigserver.rest.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import us.hgmtrebing.auswendigserver.database.repository.CardlessDeckRepository;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;
import us.hgmtrebing.auswendigserver.rest.api.DeckApi;
import us.hgmtrebing.auswendigserver.rest.exception.DeckAlreadyExistsException;
import us.hgmtrebing.auswendigserver.rest.exception.DeckDoesNotExistException;
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
    private UserRepository userRepository;

    @Override
    public HttpApiResponse<List<CardlessDeckSchema>> getAllDecksCardless() {
        var cards = deckMapper.convert(cardlessDeckRepository.findAll());
        return HttpApiResponse.passedFully(cards);
    }

    @Override
    public HttpApiResponse<CardlessDeckSchema> addCardlessDeck(CardlessDeckSchema schema) {
        if (cardlessDeckRepository.countByExternalId(schema.getExternalId()) > 0) {
            throw new DeckAlreadyExistsException(schema.getExternalId());
        }

        schema.setExternalId(null);
        var owner = userRepository.findByUsername(schema.getOwnerUsername());
        var result = cardlessDeckRepository.saveAndFlush(deckMapper.convert(schema, owner));
        return HttpApiResponse.passedFully(deckMapper.convert(result));
    }

    @Override
    public HttpApiResponse<CardlessDeckSchema> updateCardlessDeck(CardlessDeckSchema schema) {
        var entity = cardlessDeckRepository.findFirstByExternalId(schema.getExternalId());

        if (entity == null) {
            throw new DeckDoesNotExistException(schema.getExternalId());
        }

        var owner = userRepository.findByUsername(schema.getOwnerUsername());
        var result = cardlessDeckRepository.saveAndFlush(deckMapper.update(entity, schema, owner));
        return HttpApiResponse.passedFully(deckMapper.convert(result));

    }
}
