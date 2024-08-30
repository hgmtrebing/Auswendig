package us.hgmtrebing.auswendigserver.rest.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.hgmtrebing.auswendigserver.rest.schemas.OperationResponse;
import us.hgmtrebing.auswendigserver.rest.schemas.UserSchema;

import java.util.List;

@RequestMapping("/api/v1/users")
@Tag(name = "User Controller", description = "RESTful API for Auswendig Users.")
public interface UserApi {


    @GetMapping("get-all-users")
    @Operation(summary = "Get All Users.", description = "Get All Users in the System.")
    public abstract ResponseEntity<OperationResponse<List<UserSchema>>> getAllUsers();


    @GetMapping("get-user-by-username")
    @Operation(summary = "Get User by Username.", description = "Get Individual User by Username.")
    public abstract ResponseEntity<OperationResponse<UserSchema>> getUserByUsername(String username);

    @PostMapping("add-new-user")
    @Operation(summary = "Create new user.", description = "Creates a new user in the system.")
    public abstract OperationResponse<UserSchema> createUser(UserSchema schema);

    @PutMapping("update-user")
    @Operation(summary = "Modify an existing user.", description = "Modifies an existing user in the system.")
    public abstract OperationResponse<UserSchema> updateUser(@RequestParam String username, @RequestBody UserSchema newSchema);
}
