package us.hgmtrebing.auswendigserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public abstract List<UserEntity> findByUsername(String username);
}
