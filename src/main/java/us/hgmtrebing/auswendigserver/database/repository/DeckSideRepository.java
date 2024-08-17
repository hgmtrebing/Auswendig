package us.hgmtrebing.auswendigserver.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.DeckSideEntity;

@Service
public interface DeckSideRepository extends JpaRepository<DeckSideEntity, Long> {

}
