package us.hgmtrebing.auswendigserver.rest.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;
import us.hgmtrebing.auswendigserver.rest.schemas.UserRequestSchema;
import us.hgmtrebing.auswendigserver.rest.schemas.UserSchema;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    public UserEntity convert(UserRequestSchema schema) {
        if (schema == null) {
            return null;
        }

        return UserEntity.builder()
                .username(schema.getUsername())
                .firstName(schema.getFirstName())
                .lastName(schema.getLastName())
                .email(schema.getEmail())
                .phoneNumber(schema.getPhoneNumber())
                .password(passwordEncoder.encode(schema.getPassword()))
                .birthday(schema.getBirthday())
                // Set defaults for fields not present in UserRequestSchema
                .passwordLastModified(LocalDateTime.now())
                .accountLocked(false)
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
