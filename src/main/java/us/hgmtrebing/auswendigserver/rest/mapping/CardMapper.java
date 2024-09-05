package us.hgmtrebing.auswendigserver.rest.mapping;

import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;
import us.hgmtrebing.auswendigserver.rest.schemas.deck.CardSchema;

import java.util.List;

@Service
public class CardMapper {

    public List<CardSchema> convert(List<CardEntity> cardEntities) {
        if (cardEntities == null) {
            return null;
        }

        return cardEntities.stream().map(this::convert).toList();
    }

    public CardSchema convert (CardEntity entity) {
        return update(new CardSchema(), entity);
    }

    public CardEntity convert (CardSchema schema, CardlessDeckEntity deck) {
        return update(new CardEntity(), schema, deck);
    }

    public CardSchema update(CardSchema target, CardEntity source) {
        if (source == null) {
            return target;
        }

        if (source.getExternalId() != null) {
            target.setCardExternalId(source.getExternalId());
        }

        if (source.getDeck() != null && source.getDeck().getExternalId() != null) {
            target.setDeckExternalId(source.getDeck().getExternalId());
        }


        if (source.getQuestion() != null) {
            target.setQuestion(source.getQuestion());
        }

        if (source.getAnswer() != null) {
            target.setAnswer(source.getAnswer());
        }

        if (source.getNote() != null) {
            target.setNote(source.getNote());
        }

        if (source.getHint() != null) {
            target.setHint(source.getHint());
        }

        if (source.getSuccessCount() != null) {
            target.setSuccessCount(source.getSuccessCount());
        }

        if (source.getFailureCount() != null) {
            target.setFailureCount(source.getFailureCount());
        }

        if (source.getLastSuccess() != null) {
            target.setLastSuccess(source.getLastSuccess());
        }

        if (source.getLastFailure() != null) {
            target.setLastFailure(source.getLastFailure());
        }

        return target;
    }

    public CardEntity update(CardEntity target, CardSchema source, CardlessDeckEntity deck) {

        if (source == null) {
            return target;
        }

        if (source.getCardExternalId() != null) {
            target.setExternalId(source.getCardExternalId()); }

        if (deck != null) {
            target.setDeck(deck);
        }

        if (source.getQuestion() != null) {
            target.setQuestion(source.getQuestion());
        }

        if (source.getAnswer() != null) {
            target.setAnswer(source.getAnswer());
        }

        if (source.getNote() != null) {
            target.setNote(source.getNote());
        }

        if (source.getHint() != null) {
            target.setHint(source.getHint());
        }

        if (source.getSuccessCount() != null) {
            target.setSuccessCount(source.getSuccessCount());
        }

        if (source.getFailureCount() != null) {
            target.setFailureCount(source.getFailureCount());
        }

        if (source.getLastSuccess() != null) {
            target.setLastSuccess(source.getLastSuccess());
        }

        if (source.getLastFailure() != null) {
            target.setLastFailure(source.getLastFailure());
        }


        return target;
    }
}
