package us.hgmtrebing.auswendigserver.rest.mapping;

import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;
import us.hgmtrebing.auswendigserver.rest.schemas.CardlessDeckSchema;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckMapper {

    public CardlessDeckSchema convert(CardlessDeckEntity entity) {
        if (entity == null) {
            return null;
        }

        CardlessDeckSchema schema = new CardlessDeckSchema();

        if (entity.getName() != null) {
            schema.setDeckName(entity.getName());
        }

        if (entity.getDescription() != null) {
            schema.setDeckDescription(entity.getDescription());
        }

        if (entity.getOwner() != null && entity.getOwner().getUsername() != null) {
            schema.setOwnerUsername(entity.getOwner().getUsername());
        }

        if (entity.getExternalId() != null) {
            schema.setExternalId(entity.getExternalId());
        }

        return schema;
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

    public CardlessDeckEntity update(CardlessDeckEntity entity, CardlessDeckSchema schema, UserEntity owner) {
        if (schema == null) {
            return entity;
        }

        if (schema.getDeckName() != null) {
            entity.setName(schema.getDeckName());
        }

        if (schema.getDeckDescription() != null) {
            entity.setDescription(schema.getDeckDescription());
        }

        if (owner != null) {
            entity.setOwner(owner);
        }

        if (schema.getExternalId() != null) {
            entity.setExternalId(schema.getExternalId());
        }

        return entity;
    }
}

