package us.hgmtrebing.auswendigserver.database.entity.quiz;

import jakarta.persistence.*;
import lombok.Data;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardEntity;

import java.time.LocalDateTime;

@Data
@Table(name = "tbl_questions")
@Entity
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "fk_question_template_id")
    private QuestionTemplateEntity questionTemplate;

    @ManyToOne
    @JoinColumn(name = "fk_card_id")
    private CardEntity card;

    @Column(name = "total_successes")
    private int totalSuccesses;

    @Column(name = "total_failures")
    private int totalFailures;

    @Column(name = "last_success")
    private LocalDateTime lastSucccess;

    @Column(name = "last_failure")
    private LocalDateTime lastFailure;
}
