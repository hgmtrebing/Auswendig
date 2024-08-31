package us.hgmtrebing.auswendigserver.database.entity;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.deck.CardlessDeckEntity;
import us.hgmtrebing.auswendigserver.service.ExternalIdService;

@Service
@AllArgsConstructor
public class ExternalIdInjector {
    private ExternalIdService service;

    @PrePersist
    public void inject(CardlessDeckEntity entity) {
        if (entity.getExternalId() == null) {
            entity.setExternalId(service.generate());
        }
    }
}
