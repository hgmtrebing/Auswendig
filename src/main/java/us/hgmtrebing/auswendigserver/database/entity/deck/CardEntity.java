package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.Data;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;
import us.hgmtrebing.auswendigserver.database.entity.QuizzedAuswendigEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_cards")
@Data
@EntityListeners(ExternalIdInjector.class)
public class CardEntity extends QuizzedAuswendigEntity {

    @ManyToOne
    @JoinColumn(name = "fk_deck_id")
    private CardlessDeckEntity deck;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "note")
    private String note;

    @Column(name = "hint")
    private String hint;


}
