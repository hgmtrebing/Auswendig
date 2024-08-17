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
    @Column(name = "user_id")
    private long databaseId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "user_last_name", nullable = false)
    private String lastName;

    @Column(name = "user_first_name", nullable = false)
    private String firstName;

    @CreationTimestamp
    @Column(name = "user_create_timestamp", nullable = false, updatable = false)
    private ZonedDateTime createTimestamp;

    @UpdateTimestamp
    @Column(name = "user_last_mod_timestamp", nullable = false, updatable = false)
    private ZonedDateTime lastModifiedTimestamp;
}
