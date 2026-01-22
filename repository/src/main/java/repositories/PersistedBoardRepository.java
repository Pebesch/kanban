package repositories;

import models.PersistedBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersistedBoardRepository extends JpaRepository<PersistedBoard, Long> {
    Optional<PersistedBoard> findByName(String name);
}
