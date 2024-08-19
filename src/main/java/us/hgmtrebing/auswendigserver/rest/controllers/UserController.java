package us.hgmtrebing.auswendigserver.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;
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
    public OperationResponse<List<UserSchema>> getAllUsers() {
        log.info("Received request to retrieve all users.");

        try {
            return OperationResponse.passedCompletely(userMapper.convert(userRepository.findAll()));
        } catch (Exception e) {
            return errorProcessor.createErrorResponse("Failed to retrieve users from the Database.", e);
        }
    }

    @GetMapping("get-user-by-username")
    @Operation(summary = "Get User by Username.", description = "Get Individual User by Username.")
    public OperationResponse<UserSchema> getUserByUsername(String username) {
        log.info("Received request to get user: {}", username);

        try {
            var data = userMapper.convert(userRepository.findByUsername(username));
            if (data == null) {
                return errorProcessor.createErrorResponse("Failed to find user: " + username);
            }

            return OperationResponse.passedCompletely(data);

        } catch (Exception e) {
            return errorProcessor.createErrorResponse("Failed to retrieve user from the Database.", e);
        }
    }

    @PostMapping("add-new-user")
    @Operation(summary = "Create new user.", description = "Creates a new user in the system.")
    public OperationResponse<UserSchema> createUser(UserSchema schema) {
        log.info("Received request to create new user: {}", schema.toString());

        try {
            return OperationResponse.passedCompletely(userMapper.convert(
                    userRepository.saveAndFlush(userMapper.convert(schema))
            ));

        } catch (Exception e) {
            return errorProcessor.createErrorResponse("Failed to create new user.", e);
        }

    }
}
