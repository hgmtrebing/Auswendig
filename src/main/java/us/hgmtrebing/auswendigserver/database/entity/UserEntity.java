package us.hgmtrebing.auswendigserver.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_id")
    private long databaseId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @CreationTimestamp
    @Column(name = "create_ts", nullable = false, updatable = false)
    private ZonedDateTime createTimestamp;

    @UpdateTimestamp
    @Column(name = "last_mod_ts", nullable = false, updatable = false)
    private ZonedDateTime lastModifiedTimestamp;
}
