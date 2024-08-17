package us.hgmtrebing.auswendigserver;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cards")
@Data
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cardId;

}
