package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;
import us.hgmtrebing.auswendigserver.database.entity.QuizzedAuswendigEntity;
import us.hgmtrebing.auswendigserver.database.entity.SideTypeEntity;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;

import java.util.List;

@Entity
@Table(
        name = "tbl_deck",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "fk_owner_user_id"})}
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(ExternalIdInjector.class)
public class CardlessDeckEntity extends QuizzedAuswendigEntity {

    @ManyToOne
    @JoinColumn(name = "fk_owner_user_id", nullable = false)

    private UserEntity owner;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "global_hint", nullable = true, unique = false)
    private String globalHint;

    @Column(name = "global_note", nullable = true, unique = false)
    private String globalNote;

    @Column(name = "question_side_name", nullable = false, unique = false)
    private String questionSideName;

    @Column(name = "answer_side_name", nullable = false, unique = false)
    private String answerSideName;

}
