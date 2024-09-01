package us.hgmtrebing.auswendigserver.database.entity.deck;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.hgmtrebing.auswendigserver.database.ExternalIdInjector;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;
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
public class CardlessDeckEntity extends AuswendigEntity  {

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


    // Side 01 Template

    @Column(name = "side_01_name", nullable = false, unique = false)
    private String side01Name;

    @Column(name = "side_01_description", nullable = true, unique = false)
    private String side01Description;

    @Column(name = "side_01_type", nullable = false, unique = false)
    private SideTypeEntity side01Type;

    @Column(name = "side_01_global_hint", nullable = true, unique = false)
    private String side01GlobalHint;

    @Column(name = "side_01_global_note", nullable = true, unique = false)
    private String side01GlobalNote;


    // Side 02 Template

    @Column(name = "side_02_name", nullable = false, unique = false)
    private String side02Name;

    @Column(name = "side_02_description", nullable = true, unique = false)
    private String side02Description;

    @Column(name = "side_02_type", nullable = false, unique = false)
    private SideTypeEntity side02Type;

    @Column(name = "side_02_global_hint", nullable = true, unique = false)
    private String side02GlobalHint;

    @Column(name = "side_02_global_note", nullable = true, unique = false)
    private String side02GlobalNote;
}
