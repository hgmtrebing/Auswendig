package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import us.hgmtrebing.auswendigserver.database.entity.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
        name = "tbl_deck",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "fk_owner_user_id"})}
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(ExternalIdInjector.class)
public class CardlessDeckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_id")
    private long deckId;

    @Column(name="external_id", nullable = false, unique = true)
    private UUID externalId;

    @ManyToOne
    @JoinColumn(name = "fk_owner_user_id", nullable = false)
    private UserEntity owner;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "id")
    private List<CardSideTemplateEntity> cardTemplate;

    @CreationTimestamp
    @Column(name = "create_ts", nullable = false, updatable = false)
    private ZonedDateTime createTimestamp;

    @UpdateTimestamp
    @Column(name = "last_mod_ts", nullable = false, updatable = false)
    private ZonedDateTime lastModifiedTimestamp;
}
