package us.hgmtrebing.auswendigserver.rest.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;
import us.hgmtrebing.auswendigserver.rest.api.UserApi;
import us.hgmtrebing.auswendigserver.rest.exception.FailedToFindUserException;
import us.hgmtrebing.auswendigserver.rest.mapping.UserMapper;
import us.hgmtrebing.auswendigserver.rest.schemas.HttpApiResponse;
import us.hgmtrebing.auswendigserver.rest.schemas.UserSchema;
import us.hgmtrebing.auswendigserver.rest.util.ErrorProcessor;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private ErrorProcessor errorProcessor;

    @Override
    public HttpApiResponse<List<UserSchema>> getAllUsers() {

        log.info("Received request to retrieve all users.");
        return HttpApiResponse.passedFully(userMapper.convert(userRepository.findAll()));
    }

    @Override
    public HttpApiResponse<UserSchema> getUserByUsername(String username) {
        log.info("Received request to get user: {}", username);

        var data = userMapper.convert(userRepository.findByUsername(username));
        if (data == null) {
            throw new FailedToFindUserException(username);
        }

        return HttpApiResponse.passedFully(data);

    }

    @Override
    public HttpApiResponse<UserSchema> createUser(UserSchema schema) {
        log.info("Received request to create new user: {}", schema.toString());
        return HttpApiResponse.passedFully(userMapper.convert(
                userRepository.saveAndFlush(userMapper.convert(schema))
        ));
    }

    @Override
    public HttpApiResponse<UserSchema> updateUser(String username, UserSchema newSchema) {

        log.info("Received request to modify user '{}' to '{}'", username, newSchema);
        var entity = userRepository.findByUsername(username);
        if (entity == null) {
            throw new FailedToFindUserException(username);
        }

        var newEntity = userRepository.saveAndFlush(userMapper.update(entity, newSchema));
        return HttpApiResponse.passedFully(userMapper.convert(newEntity));
    }
}
