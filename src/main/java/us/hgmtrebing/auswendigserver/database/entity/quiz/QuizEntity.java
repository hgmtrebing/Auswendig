package us.hgmtrebing.auswendigserver.database.entity.quiz;

import jakarta.persistence.*;
import lombok.Data;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_quizzes")
@Data
@EntityListeners(ExternalIdInjector.class)
public class QuizEntity extends AuswendigEntity {

    @ManyToOne
    @JoinColumn(name = "fk_owner_user_id")
    private UserEntity owner;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "last_quiz_date")
    private LocalDateTime lastQuizDate;
}
