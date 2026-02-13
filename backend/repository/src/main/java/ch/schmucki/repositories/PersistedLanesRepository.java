package ch.schmucki.repositories;

import ch.schmucki.models.PersistedLane;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersistedLanesRepository extends JpaRepository<PersistedLane, Long> {
  List<PersistedLane> findAllByBoardId(Long boardId);
}
