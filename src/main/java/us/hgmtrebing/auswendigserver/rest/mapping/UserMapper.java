package us.hgmtrebing.auswendigserver.rest.mapping;

import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;
import us.hgmtrebing.auswendigserver.rest.schemas.UserSchema;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

    public List<UserSchema> convert (List<UserEntity> entities) {
        if (entities == null) {
            return null;
        }

        return entities.stream().map(this::convert).toList();
    }

    public UserSchema convert (UserEntity entity) {
        if (entity == null) {
            return null;
        }

        return UserSchema.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .username(entity.getUsername())
                .build();
    }

    public UserEntity convert (UserSchema schema) {
        return update(new UserEntity(), schema);
    }

    public UserEntity update(UserEntity entity, UserSchema schema) {
        if (entity == null || schema == null) {
            return entity;
        }

        if (schema.getUsername() != null) {
            entity.setUsername(schema.getUsername());
        }

        if (schema.getFirstName() != null) {
            entity.setFirstName(schema.getFirstName());
        }

        if (schema.getLastName() != null) {
            entity.setLastName(schema.getLastName());
        }

        return entity;
    }

}
