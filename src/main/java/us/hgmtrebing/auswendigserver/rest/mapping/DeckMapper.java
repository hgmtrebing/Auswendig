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

        if (entity.getGlobalNote() != null) {
            schema.setGlobalNote(entity.getGlobalNote());
        }

        if (entity.getGlobalHint() != null) {
            schema.setGlobalHint(entity.getGlobalHint());
        }


        // Side 01 Template Fieelds

        if (entity.getSide01Name() != null) {
            schema.setSide01Name(entity.getSide01Name());
        }

        if (entity.getSide01Description() != null) {
            schema.setSide01Description(entity.getSide01Description());
        }

        if (entity.getSide01Type() != null) {
            schema.setSide01Type(convert(entity.getSide01Type()));
        }

        if (entity.getSide01GlobalHint() != null) {
            schema.setSide01GlobalHint(entity.getSide01GlobalHint());
        }

        if (entity.getSide01GlobalNote() != null) {
            schema.setSide01GlobalNote(entity.getSide01GlobalNote());
        }


        // Side 02 Template Fieelds

        if (entity.getSide02Name() != null) {
            schema.setSide02Name(entity.getSide02Name());
        }

        if (entity.getSide02Description() != null) {
            schema.setSide02Description(entity.getSide02Description());
        }

        if (entity.getSide02Type() != null) {
            schema.setSide02Type(convert(entity.getSide02Type()));
        }

        if (entity.getSide02GlobalHint() != null) {
            schema.setSide02GlobalHint(entity.getSide02GlobalHint());
        }

        if (entity.getSide02GlobalNote() != null) {
            schema.setSide02GlobalNote(entity.getSide02GlobalNote());
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


        if (schema.getGlobalNote() != null) {
            entity.setGlobalNote(schema.getGlobalNote());
        }

        if (schema.getGlobalHint() != null) {
            entity.setGlobalHint(schema.getGlobalHint());
        }


        // Side 01 Template Fieelds

        if (schema.getSide01Name() != null) {
            entity.setSide01Name(schema.getSide01Name());
        }

        if (schema.getSide01Description() != null) {
            entity.setSide01Description(schema.getSide01Description());
        }

        if (schema.getSide01Type() != null) {
            entity.setSide01Type(convert(schema.getSide01Type()));
        }

        if (schema.getSide01GlobalHint() != null) {
            entity.setSide01GlobalHint(schema.getSide01GlobalHint());
        }

        if (schema.getSide01GlobalNote() != null) {
            entity.setSide01GlobalNote(schema.getSide01GlobalNote());
        }


        // Side 02 Template Fieelds

        if (schema.getSide02Name() != null) {
            entity.setSide02Name(schema.getSide02Name());
        }

        if (schema.getSide02Description() != null) {
            entity.setSide02Description(schema.getSide02Description());
        }

        if (schema.getSide02Type() != null) {
            entity.setSide02Type(convert(schema.getSide02Type()));
        }

        if (schema.getSide02GlobalHint() != null) {
            entity.setSide02GlobalHint(schema.getSide02GlobalHint());
        }

        if (schema.getSide02GlobalNote() != null) {
            entity.setSide02GlobalNote(schema.getSide02GlobalNote());
        }



        return entity;
    }
}

