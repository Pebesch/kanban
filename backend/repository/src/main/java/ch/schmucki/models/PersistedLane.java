package ch.schmucki.models;

import ch.schmucki.core.board.Lane;
import ch.schmucki.core.board.LaneId;
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
public class PersistedLane {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne private PersistedBoard board;

  private int ordinal;
  private String title;
  private int maxNumberOfItems;

  @ManyToMany
  @JoinTable(
      name = "lane_successors",
      joinColumns = @JoinColumn(name = "lane_id"),
      inverseJoinColumns = @JoinColumn(name = "successor_id"))
  private List<PersistedLane> nextLanes;

  @ManyToMany(mappedBy = "nextLanes")
  private List<PersistedLane> previousLanes;

  public static PersistedLane fromDomain(Lane lane) {
    var persistedLane = new PersistedLane();
    persistedLane.setBoard(null);
    persistedLane.setOrdinal(lane.getOrdinal());
    persistedLane.setTitle(lane.getTitle());
    persistedLane.setMaxNumberOfItems(lane.getMaxNumberOfItems());
    persistedLane.setNextLanes(null);
    persistedLane.setPreviousLanes(null);
    return persistedLane;
  }

  public Lane toDomain() {
    return new Lane(
        new LaneId(this.id),
        this.ordinal,
        this.title,
        this.maxNumberOfItems,
        this.nextLanes.stream().map(PersistedLane::toDomain).toList(),
        this.previousLanes.stream().map(PersistedLane::toDomain).toList(),
        new ArrayList<>());
  }
}
