package models;


import ch.schmucki.core.board.KanbanBoard;
import ch.schmucki.core.board.KanbanBoardId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    public KanbanBoard toDomain() {
        return new KanbanBoard(new KanbanBoardId(id), name);
    }
}
