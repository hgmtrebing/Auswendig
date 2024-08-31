package us.hgmtrebing.auswendigserver.database.entity.quiz;

import jakarta.persistence.*;
import lombok.Data;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;

@Data
@Entity
@Table(name = "tbl_quiz_questions")
@EntityListeners(ExternalIdInjector.class)
public class QuizQuestionEntity extends AuswendigEntity {

    @ManyToOne
    @JoinColumn(name = "fk_quiz_id")
    private QuizEntity quiz;

    @ManyToOne
    @JoinColumn(name = "fk_question_template_id")
    private QuestionTemplateEntity questionTemplate;

    @Column(name = "quiz_rank")
    private int quizRank;

    @Column(name = "last_success_date_rank")
    private int lastSuccessDateRank;

    @Column(name = "minimum_success_count_rank")
    private int minimumSuccessCountRank;

    @Column(name = "failed_recently_rank")
    private int failedRecentlyRank;
}
