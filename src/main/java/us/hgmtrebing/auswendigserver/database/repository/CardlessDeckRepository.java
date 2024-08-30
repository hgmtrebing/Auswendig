package us.hgmtrebing.auswendigserver.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;

@Service
public interface CardlessDeckRepository extends JpaRepository<CardlessDeckEntity, Long> {

}
