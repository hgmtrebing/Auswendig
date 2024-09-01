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


        // Set Side 01 Fields

        if (source.getSide01Value() != null) {
            target.setSide01Value(source.getSide01Value());
        }

        if (source.getSide01Note() != null) {
            target.setSide01Note(source.getSide01Note());
        }

        if (source.getSide01Hint() != null) {
            target.setSide01Hint(source.getSide01Hint());
        }

        if (source.getSide01SuccessCount() != null) {
            target.setSide01SuccessCount(source.getSide01SuccessCount());
        }

        if (source.getSide01FailureCount() != null) {
            target.setSide01FailureCount(source.getSide01FailureCount());
        }

        if (source.getSide01LastSuccess() != null) {
            target.setSide01LastSuccess(source.getSide01LastSuccess());
        }

        if (source.getSide01LastFailure() != null) {
            target.setSide01LastFailure(source.getSide01LastFailure());
        }


        // Set Side 02 Fields

        if (source.getSide02Value() != null) {
            target.setSide02Value(source.getSide02Value());
        }

        if (source.getSide02Note() != null) {
            target.setSide02Note(source.getSide02Note());
        }

        if (source.getSide02Hint() != null) {
            target.setSide02Hint(source.getSide02Hint());
        }

        if (source.getSide02SuccessCount() != null) {
            target.setSide02SuccessCount(source.getSide02SuccessCount());
        }

        if (source.getSide02FailureCount() != null) {
            target.setSide02FailureCount(source.getSide02FailureCount());
        }

        if (source.getSide02LastSuccess() != null) {
            target.setSide02LastSuccess(source.getSide02LastSuccess());
        }

        if (source.getSide02LastFailure() != null) {
            target.setSide02LastFailure(source.getSide02LastFailure());
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


        // Set Side 01 Fields

        if (source.getSide01Value() != null) {
            target.setSide01Value(source.getSide01Value());
        }

        if (source.getSide01Note() != null) {
            target.setSide01Note(source.getSide01Note());
        }

        if (source.getSide01Hint() != null) {
            target.setSide01Hint(source.getSide01Hint());
        }

        if (source.getSide01SuccessCount() != null) {
            target.setSide01SuccessCount(source.getSide01SuccessCount());
        }

        if (source.getSide01FailureCount() != null) {
            target.setSide01FailureCount(source.getSide01FailureCount());
        }

        if (source.getSide01LastSuccess() != null) {
            target.setSide01LastSuccess(source.getSide01LastSuccess());
        }

        if (source.getSide01LastFailure() != null) {
            target.setSide01LastFailure(source.getSide01LastFailure());
        }


        // Set Side 02 Fields

        if (source.getSide02Value() != null) {
            target.setSide02Value(source.getSide02Value());
        }

        if (source.getSide02Note() != null) {
            target.setSide02Note(source.getSide02Note());
        }

        if (source.getSide02Hint() != null) {
            target.setSide02Hint(source.getSide02Hint());
        }

        if (source.getSide02SuccessCount() != null) {
            target.setSide02SuccessCount(source.getSide02SuccessCount());
        }

        if (source.getSide02FailureCount() != null) {
            target.setSide02FailureCount(source.getSide02FailureCount());
        }

        if (source.getSide02LastSuccess() != null) {
            target.setSide02LastSuccess(source.getSide02LastSuccess());
        }

        if (source.getSide02LastFailure() != null) {
            target.setSide02LastFailure(source.getSide02LastFailure());
        }

        return target;
    }
}
