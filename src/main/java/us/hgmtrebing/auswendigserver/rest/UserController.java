package us.hgmtrebing.auswendigserver.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Controller", description = "RESTful API for Auswendig Users.")
public class UserController {

    @GetMapping("get-user")
    @Operation(summary = "Get Basic User Information.", description = "Get Basic User Information.")
    public String getUser() {
        return "Test!";
    }
}
