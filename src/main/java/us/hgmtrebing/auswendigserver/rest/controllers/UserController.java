package us.hgmtrebing.auswendigserver.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;
import us.hgmtrebing.auswendigserver.rest.api.UserApi;
import us.hgmtrebing.auswendigserver.rest.exception.FailedToFindUserException;
import us.hgmtrebing.auswendigserver.rest.mapping.UserMapper;
import us.hgmtrebing.auswendigserver.rest.schemas.OperationResponse;
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
    public ResponseEntity<OperationResponse<List<UserSchema>>> getAllUsers() {

        log.info("Received request to retrieve all users.");
        return ResponseEntity.ok(
                OperationResponse.passedCompletely(
                        userMapper.convert(userRepository.findAll())
                ));
    }

    @Override
    public ResponseEntity<OperationResponse<UserSchema>> getUserByUsername(String username) {
        log.info("Received request to get user: {}", username);

        var data = userMapper.convert(userRepository.findByUsername(username));
        if (data == null) {
            throw new FailedToFindUserException(username);
        }

        return ResponseEntity.ok(OperationResponse.passedCompletely(data));

    }

    @Override
    public OperationResponse<UserSchema> createUser(UserSchema schema) {
        log.info("Received request to create new user: {}", schema.toString());
        return OperationResponse.passedCompletely(userMapper.convert(
                userRepository.saveAndFlush(userMapper.convert(schema))
        ));
    }

    @Override
    public OperationResponse<UserSchema> updateUser(String username, UserSchema newSchema) {

        log.info("Received request to modify user '{}' to '{}'", username, newSchema);
        var entity = userRepository.findByUsername(username);
        if (entity == null) {
            throw new FailedToFindUserException(username);
        }

        var newEntity = userRepository.saveAndFlush(userMapper.update(entity, newSchema));
        return OperationResponse.passedCompletely(userMapper.convert(newEntity));
    }
}
