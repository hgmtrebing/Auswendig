package us.hgmtrebing.auswendigserver.database.entity.quiz;

import jakarta.persistence.*;
import lombok.Data;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardSideTemplateEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.DeckEntity;

@Data
@Table(name = "tbl_question_templates")
@Entity
public class QuestionTemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "fk_question_side_id")
    private CardSideTemplateEntity questionSide;

    @ManyToOne
    @JoinColumn(name = "fk_answer_side_id")
    private CardSideTemplateEntity answerSide;

    @Column(name = "question_type")
    private QuestionTypeEntity questionType;

    @ManyToOne
    @JoinColumn(name = "fk_deck_id")
    private DeckEntity deck;
}
