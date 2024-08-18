package us.hgmtrebing.auswendigserver.rest.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Schema to encapsulate user data.")
public class UserSchema {

    @Schema(description = "The user's unique username.")
    private String username;

    @Schema(description = "The user's first name.")
    private String firstName;

    @Schema(description = "The user's last name.")
    private String lastName;

}
