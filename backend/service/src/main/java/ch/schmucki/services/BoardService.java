package ch.schmucki.services;

import ch.schmucki.core.board.KanbanBoard;
import ch.schmucki.models.PersistedBoard;
import ch.schmucki.repositories.PersistedBoardRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
  private final PersistedBoardRepository persistedBoardRepository;

  @Autowired
  public BoardService(PersistedBoardRepository persistedBoardRepository) {
    this.persistedBoardRepository = persistedBoardRepository;
  }

  public List<KanbanBoard> findAll() {
    return persistedBoardRepository.findAll().stream().map(PersistedBoard::toDomain).toList();
  }

  public Optional<PersistedBoard> findByName(String name) {
    return persistedBoardRepository.findByName(name);
  }

  public PersistedBoard createBoard(KanbanBoard kanbanBoard) {
    return persistedBoardRepository.save(PersistedBoard.fromDomain(kanbanBoard));
  }
}
