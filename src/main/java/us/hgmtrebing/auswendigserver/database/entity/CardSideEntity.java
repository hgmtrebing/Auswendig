package us.hgmtrebing.auswendigserver.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_card_sides")
@Data
public class CardSideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "fk_card_id")
    private CardEntity card;

    @ManyToOne
    @JoinColumn(name = "fk_card_side_template_id")
    private CardSideTemplateEntity template;

    @Column(name = "data")
    private String data;
}
