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
    return new PersistedLane(
        lane.getId().laneId(),
        null,
        lane.getOrdinal(),
        lane.getTitle(),
        lane.getMaxNumberOfItems(),
        lane.getNextLanes().stream().map(PersistedLane::fromDomain).toList(),
        lane.getPreviousLanes().stream().map(PersistedLane::fromDomain).toList());
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
