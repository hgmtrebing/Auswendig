package us.hgmtrebing.auswendigserver.rest.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.hgmtrebing.auswendigserver.database.repository.UserRepository;
import us.hgmtrebing.auswendigserver.rest.schemas.RequestResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Controller", description = "RESTful API for Auswendig Users.")
public class UserController {

    private UserRepository userRepository;

    @GetMapping("get-all-users")
    @Operation(summary = "Get All Users.", description = "Get All Users in the System.")
    public RequestResponse<List<String>> getUser() {
        RequestResponse<List<String>> r = new RequestResponse<>();
        r.setData(new ArrayList<>());
        return r;
    }
}
