package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.Data;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;

@Entity
@Table(name = "tbl_card_sides")
@Data
@EntityListeners(ExternalIdInjector.class)
public class CardSideEntity extends AuswendigEntity {

    @ManyToOne
    @JoinColumn(name = "fk_card_id")
    private CardEntity card;

    @ManyToOne
    @JoinColumn(name = "fk_card_side_template_id")
    private CardSideTemplateEntity template;

    @Column(name = "data")
    private String data;
}
