package us.hgmtrebing.auswendigserver.rest.mapping;

import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.SideTypeEntity;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;
import us.hgmtrebing.auswendigserver.rest.schemas.deck.CardlessDeckSchema;
import us.hgmtrebing.auswendigserver.rest.schemas.deck.SideTypeSchema;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckMapper {

    public SideTypeEntity convert(SideTypeSchema type) {
        if (type == null) {
            return null;
        }

        switch (type) {
            case TEXT:
                return SideTypeEntity.TEXT;

            default:
                return null;

        }
    }

    public SideTypeSchema convert(SideTypeEntity type) {
        if (type == null) {
            return null;
        }

        switch (type) {
            case TEXT:
                return SideTypeSchema.TEXT;

            default:
                return null;
        }
    }

    public CardlessDeckSchema convert(CardlessDeckEntity source) {
        if (source == null) {
            return null;
        }

        CardlessDeckSchema target = new CardlessDeckSchema();

        if (source.getName() != null) {
            target.setDeckName(source.getName());
        }

        if (source.getDescription() != null) {
            target.setDeckDescription(source.getDescription());
        }

        if (source.getOwner() != null && source.getOwner().getUsername() != null) {
            target.setOwnerUsername(source.getOwner().getUsername());
        }

        if (source.getExternalId() != null) {
            target.setExternalId(source.getExternalId());
        }

        if (source.getGlobalNote() != null) {
            target.setGlobalNote(source.getGlobalNote());
        }

        if (source.getGlobalHint() != null) {
            target.setGlobalHint(source.getGlobalHint());
        }


        if (source.getQuestionSideName() != null) {
            target.setQuestionSideName(source.getQuestionSideName());
        }

        if (source.getAnswerSideName() != null) {
            target.setAnswerSideName(source.getAnswerSideName());
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

    public CardlessDeckEntity convert(CardlessDeckSchema schema, UserEntity owner) {
        return update(new CardlessDeckEntity(), schema, owner);
    }

    public List<CardlessDeckSchema> convert(List<CardlessDeckEntity> entities) {
        if (entities == null) {
            return null;
        }

        List<CardlessDeckSchema> schemas = new ArrayList<>();

        for (CardlessDeckEntity entity : entities) {
            schemas.add(this.convert(entity));
        }

        return schemas;
    }

    public CardlessDeckEntity update(CardlessDeckEntity target, CardlessDeckSchema source, UserEntity owner) {
        if (source == null) {
            return target;
        }

        if (source.getDeckName() != null) {
            target.setName(source.getDeckName());
        }

        if (source.getDeckDescription() != null) {
            target.setDescription(source.getDeckDescription());
        }

        if (owner != null) {
            target.setOwner(owner);
        }

        if (source.getExternalId() != null) {
            target.setExternalId(source.getExternalId());
        }

        if (source.getGlobalNote() != null) {
            target.setGlobalNote(source.getGlobalNote());
        }

        if (source.getGlobalHint() != null) {
            target.setGlobalHint(source.getGlobalHint());
        }

        if (source.getQuestionSideName() != null) {
            target.setQuestionSideName(source.getQuestionSideName());
        }

        if (source.getAnswerSideName() != null) {
            target.setAnswerSideName(source.getAnswerSideName());
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

