package ch.schmucki.models;

import ch.schmucki.core.board.KanbanBoard;
import ch.schmucki.core.board.KanbanBoardId;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersistedBoard {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PersistedLane> lanes = new ArrayList<PersistedLane>();

  public static PersistedBoard fromDomain(KanbanBoard kanbanBoard) {
    return new PersistedBoard(
        kanbanBoard.getId().kanbanBoardId(),
        kanbanBoard.getName(),
        kanbanBoard.getLanes().stream().map(PersistedLane::fromDomain).toList());
  }

  public KanbanBoard toDomain() {
    return new KanbanBoard(new KanbanBoardId(id), name);
  }
}
