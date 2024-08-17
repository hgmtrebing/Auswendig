package us.hgmtrebing.auswendigserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DeckRepository extends JpaRepository<DeckEntity, Long> {

}
