package us.hgmtrebing.auswendigserver;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "decks")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deck_id")
    private long deckId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity owner;

    @Column(name = "deck_name", nullable = false)
    private String deckName;

    @OneToMany(mappedBy = "id")
    // @JoinColumn(name = "deck_side_id")
    private List<DeckSideEntity> deckSides;

    @CreationTimestamp
    @Column(name = "deck_create_timestamp", nullable = false, updatable = false)
    private ZonedDateTime createTimestamp;

    @UpdateTimestamp
    @Column(name = "deck_last_mod_timestamp", nullable = false, updatable = false)
    private ZonedDateTime lastModifiedTimestamp;
}
