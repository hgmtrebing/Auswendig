package us.hgmtrebing.auswendigserver.database;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.AuswendigEntity;
import us.hgmtrebing.auswendigserver.service.ExternalIdService;

@Service
@AllArgsConstructor
public class ExternalIdInjector {
    private ExternalIdService service;

    @PrePersist
    public void inject(AuswendigEntity entity) {
        if (entity.getExternalId() == null) {
            entity.setExternalId(service.generate());
        }
    }
}
