package us.hgmtrebing.auswendigserver;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "card_sides")
@Data
public class CardSideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_side_id")
    private long id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_side_value")
    private String value;
}
