package ch.schmucki.repositories;

import ch.schmucki.models.PersistedBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersistedBoardRepository extends JpaRepository<PersistedBoard, Long> {
    Optional<PersistedBoard> findByName(String name);
}
