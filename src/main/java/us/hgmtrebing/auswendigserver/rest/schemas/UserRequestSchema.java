package us.hgmtrebing.auswendigserver.rest.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Schema to encapsulate user data.")
public class UserRequestSchema {

    @Schema(description = "The user's unique username.", example = "orabbit")
    private String username;

    @Schema(description = "The user's first name.", example = "Oswald")
    private String firstName;

    @Schema(description = "The user's last name.", example = "Lucky Rabbit")
    private String lastName;

    @Schema(description = "The user's email address.", example = "oswald@example.com")
    private String email;

    @Schema(description = "The user's phone number.", example = "+1234567890")
    private String phoneNumber;

    @Schema(description = "The user's hashed password.", example = "$2a$10$...")
    private String password;

    @Schema(description = "The user's birthday.", example = "1990-01-01")
    private LocalDate birthday;
}
