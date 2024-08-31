package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;

import java.util.List;

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
public class CardlessDeckEntity extends AuswendigEntity  {

    @ManyToOne
    @JoinColumn(name = "fk_owner_user_id", nullable = false)
    private UserEntity owner;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "id")
    private List<CardSideTemplateEntity> cardTemplate;
}
