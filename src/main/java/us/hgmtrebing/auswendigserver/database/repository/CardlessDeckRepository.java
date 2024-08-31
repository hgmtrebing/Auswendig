package us.hgmtrebing.auswendigserver.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;

import java.util.UUID;

@Service
public interface CardlessDeckRepository extends JpaRepository<CardlessDeckEntity, Long> {

    public abstract int countByExternalId(UUID externalId);
    public abstract CardlessDeckEntity findFirstByExternalId(UUID externalId);
}
