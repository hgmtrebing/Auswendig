package us.hgmtrebing.auswendigserver.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExternalIdServiceImpl implements ExternalIdService {

    private SecureRandom numberGenerator;

    public UUID generate() {
        long timestamp = System.currentTimeMillis();
        long random = numberGenerator.nextLong();

        return new UUID(timestamp, random);
    }
}
