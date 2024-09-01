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


    // Side 01 Fields

    @Column(name = "side_01_value")
    private String side01Value;

    @Column(name = "side_01_note")
    private String side01Note;

    @Column(name = "side_01_hint")
    private String side01Hint;

    @Column(name = "side_01_success_count")
    private Long side01SuccessCount;

    @Column(name = "side_01_failure_count")
    private Long side01FailureCount;

    @Column(name = "side_01_last_success")
    private LocalDateTime side01LastSuccess;

    @Column(name = "side_01_last_failure")
    private LocalDateTime side01LastFailure;


    // Side 02 Fields

    @Column(name = "side_02_value")
    private String side02Value;

    @Column(name = "side_02_note")
    private String side02Note;

    @Column(name = "side_02_hint")
    private String side02Hint;

    @Column(name = "side_02_success_count")
    private Long side02SuccessCount;

    @Column(name = "side_02_failure_count")
    private Long side02FailureCount;

    @Column(name = "side_02_last_success")
    private LocalDateTime side02LastSuccess;

    @Column(name = "side_02_last_failure")
    private LocalDateTime side02LastFailure;
}
