package us.hgmtrebing.auswendigserver.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AuswendigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_id")
    private long id;

    @Column(name="external_id", nullable = false, unique = true)
    private UUID externalId;

    @CreationTimestamp
    @Column(name = "create_ts", nullable = false, updatable = false)
    private ZonedDateTime createTimestamp;

    @UpdateTimestamp
    @Column(name = "last_mod_ts", nullable = false, updatable = false)
    private ZonedDateTime lastModifiedTimestamp;
}
