package us.hgmtrebing.auswendigserver.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;

import java.time.ZonedDateTime;

@Entity
@Table(name = "tbl_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(ExternalIdInjector.class)
public class UserEntity extends AuswendigEntity {

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;
}
