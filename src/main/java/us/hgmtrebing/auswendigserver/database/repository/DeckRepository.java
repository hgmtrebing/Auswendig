package us.hgmtrebing.auswendigserver.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.deck.DeckEntity;

@Service
public interface DeckRepository extends JpaRepository<DeckEntity, Long> {

}
