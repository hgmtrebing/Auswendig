package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_cards")
@Data
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cardId;

    @ManyToOne
    @JoinColumn(name = "fk_deck_id")
    private CardlessDeckEntity deck;
}
