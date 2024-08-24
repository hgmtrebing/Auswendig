package us.hgmtrebing.auswendigserver.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;
import us.hgmtrebing.auswendigserver.rest.exception.FailedToFindUserException;
import us.hgmtrebing.auswendigserver.rest.mapping.UserMapper;
import us.hgmtrebing.auswendigserver.rest.schemas.OperationStatus;
import us.hgmtrebing.auswendigserver.rest.schemas.OperationResponse;
import us.hgmtrebing.auswendigserver.rest.schemas.UserSchema;
import us.hgmtrebing.auswendigserver.rest.util.ErrorProcessor;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Controller", description = "RESTful API for Auswendig Users.")
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private ErrorProcessor errorProcessor;

    @GetMapping("get-all-users")
    @Operation(summary = "Get All Users.", description = "Get All Users in the System.")
    public ResponseEntity<OperationResponse<List<UserSchema>>> getAllUsers() {

        log.info("Received request to retrieve all users.");
        return ResponseEntity.ok(
                OperationResponse.passedCompletely(
                        userMapper.convert(userRepository.findAll())
                ));
    }

    @GetMapping("get-user-by-username")
    @Operation(summary = "Get User by Username.", description = "Get Individual User by Username.")
    public ResponseEntity<OperationResponse<UserSchema>> getUserByUsername(String username) {
        log.info("Received request to get user: {}", username);

        var data = userMapper.convert(userRepository.findByUsername(username));
        if (data == null) {
            throw new FailedToFindUserException(username);
        }

        return ResponseEntity.ok(OperationResponse.passedCompletely(data));

    }

    @PostMapping("add-new-user")
    @Operation(summary = "Create new user.", description = "Creates a new user in the system.")
    public OperationResponse<UserSchema> createUser(UserSchema schema) {
        log.info("Received request to create new user: {}", schema.toString());
        return OperationResponse.passedCompletely(userMapper.convert(
                userRepository.saveAndFlush(userMapper.convert(schema))
        ));
    }

    @PutMapping("update-user")
    @Operation(summary = "Modify an existing user.", description = "Modifies an existing user in the system.")
    public OperationResponse<UserSchema> updateUser(@RequestParam String username, @RequestBody UserSchema newSchema) {

        log.info("Received request to modify user '{}' to '{}'", username, newSchema);
        var entity = userRepository.findByUsername(username);
        if (entity == null) {
            throw new FailedToFindUserException(username);
        }

        var newEntity = userRepository.saveAndFlush(userMapper.update(entity, newSchema));
        return OperationResponse.passedCompletely(userMapper.convert(newEntity));
    }
}
