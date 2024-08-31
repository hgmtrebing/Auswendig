package us.hgmtrebing.auswendigserver.database.entity.quiz;

import jakarta.persistence.*;
import lombok.Data;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardSideTemplateEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;

@Data
@Table(name = "tbl_question_templates")
@Entity
@EntityListeners(ExternalIdInjector.class)
public class QuestionTemplateEntity extends AuswendigEntity {

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
    private CardlessDeckEntity deck;
}
