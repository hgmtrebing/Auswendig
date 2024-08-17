package us.hgmtrebing.auswendigserver.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deck_sides")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeckSideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deck_side_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "deck_id", nullable = false)
    private DeckEntity deck;

    @Column(name = "deck_side_name")
    private String name;
}
