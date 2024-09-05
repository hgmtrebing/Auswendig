package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.Data;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_cards")
@Data
@EntityListeners(ExternalIdInjector.class)
public class CardEntity extends AuswendigEntity {

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

    @Column(name = "success_count")
    private Long successCount;

    @Column(name = "failure_count")
    private Long failureCount;

    @Column(name = "last_success")
    private LocalDateTime lastSuccess;

    @Column(name = "last_failure")
    private LocalDateTime lastFailure;

}
