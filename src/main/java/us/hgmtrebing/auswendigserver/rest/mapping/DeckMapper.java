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
        schema.setDeckName(entity.getName());
        schema.setDeckDescription(entity.getDescription());
        schema.setOwnerUsername(entity.getOwner().getUsername());
        return schema;
    }

    public CardlessDeckEntity convert(CardlessDeckSchema schema, UserEntity owner) {
        if (schema == null) {
            return null;
        }

        CardlessDeckEntity entity = new CardlessDeckEntity();
        entity.setName(schema.getDeckName());
        entity.setDescription(schema.getDeckDescription());
        entity.setOwner(owner);
        return entity;
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
}

