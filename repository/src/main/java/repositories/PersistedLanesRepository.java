package repositories;

import models.PersistedLane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersistedLanesRepository extends JpaRepository<PersistedLane, Long> {
    List<PersistedLane> findAllByBoardId(Long boardId);
}
