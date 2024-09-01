package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;
import us.hgmtrebing.auswendigserver.database.entity.SideTypeEntity;

@Entity
@Table(name = "tbl_card_side_template")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(ExternalIdInjector.class)
public class CardSideTemplateEntity extends AuswendigEntity  {

    @ManyToOne
    @JoinColumn(name = "fk_deck_id", nullable = false)
    private CardlessDeckEntity deck;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private SideTypeEntity sideType;
}
