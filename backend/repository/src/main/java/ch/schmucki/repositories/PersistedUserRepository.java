package ch.schmucki.repositories;

import ch.schmucki.models.PersistedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersistedUserRepository extends JpaRepository<PersistedUser, Long> {
    PersistedUser findByUsername(String username);
}
