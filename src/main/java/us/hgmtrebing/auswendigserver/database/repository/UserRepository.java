package us.hgmtrebing.auswendigserver.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import us.hgmtrebing.auswendigserver.database.entity.UserEntity;

import java.util.List;

@Service
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public abstract UserEntity findByUsername(String username);
    public abstract void deleteByUsername(String username);
}
