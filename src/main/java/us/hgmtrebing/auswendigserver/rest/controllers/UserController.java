package us.hgmtrebing.auswendigserver.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;
import us.hgmtrebing.auswendigserver.rest.mapping.UserMapper;
import us.hgmtrebing.auswendigserver.rest.schemas.OperationStatus;
import us.hgmtrebing.auswendigserver.rest.schemas.RequestResponse;
import us.hgmtrebing.auswendigserver.rest.schemas.UserSchema;
import us.hgmtrebing.auswendigserver.rest.util.ErrorProcessor;

import java.util.ArrayList;
import java.util.List;

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
    public RequestResponse<List<UserSchema>> getAllUsers() {
        var request = new RequestResponse<List<UserSchema>>();
        try {
            request.setData(userMapper.convert(userRepository.findAll()));
            request.addOperationResponse(OperationStatus.PASSED_COMPLETELY, null);
        } catch (Exception e) {
           request = errorProcessor.addErrorAndLog("Failed to retrieve users from the Database.", e, request);
        }

        return request;
    }

    @GetMapping("get-user-by-username")
    @Operation(summary = "Get User by Username.", description = "Get Individual User by Username.")
    public RequestResponse<UserSchema> getUserByUsername(String username) {
        var request = new RequestResponse<UserSchema>();
        try {
            request.setData(userMapper.convert(userRepository.findByUsername(username)));
            if (request.getData() == null) {
                request.addOperationResponse(OperationStatus.FAILED_COMPLETELY,
                        "Failed to find user with username: " + username);
            } else {
                request.addOperationResponse(OperationStatus.PASSED_COMPLETELY, null);
            }

        } catch (Exception e) {
            request = errorProcessor.addErrorAndLog("Failed to retrieve user from the Database.", e, request);
        }

        return request;
    }
}
