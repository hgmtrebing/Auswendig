package us.hgmtrebing.auswendigserver.database.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardEntity;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;

import java.util.List;
import java.util.UUID;

@Service
public interface CardRepository extends JpaRepository<CardEntity, Long> {

    public abstract List<CardEntity> findAllByDeck(CardlessDeckEntity deck);
    public abstract CardEntity findFirstByExternalId(UUID externalId);
}
