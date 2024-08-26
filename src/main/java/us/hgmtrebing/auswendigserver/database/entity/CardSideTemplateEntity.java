package us.hgmtrebing.auswendigserver.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_card_side_template")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardSideTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "fk_deck_id", nullable = false)
    private DeckEntity deck;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private SideType sideType;
}
