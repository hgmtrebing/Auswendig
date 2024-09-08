package us.hgmtrebing.auswendigserver.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class QuizzedAuswendigEntity extends AuswendigEntity {

    @Column(name = "success_count")
    private Long successCount;

    @Column(name = "failure_count")
    private Long failureCount;

    @Column(name = "last_success")
    private LocalDateTime lastSuccess;

    @Column(name = "last_failure")
    private LocalDateTime lastFailure;
}
