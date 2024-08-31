package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.Data;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;

@Entity
@Table(name = "tbl_cards")
@Data
@EntityListeners(ExternalIdInjector.class)
public class CardEntity extends AuswendigEntity {

    @ManyToOne
    @JoinColumn(name = "fk_deck_id")
    private CardlessDeckEntity deck;
}
