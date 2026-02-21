package ch.schmucki.core.board;

import java.util.ArrayList;
import java.util.List;

public class KanbanBoard {
  private KanbanBoardId id;
  private String name;
  private final List<Lane> lanes;

  public KanbanBoard(KanbanBoardId id, String name) {
    this.id = id;
    this.name = name;
    this.lanes = new ArrayList<>();
  }

  public KanbanBoard() {
    this.lanes = new ArrayList<>();
    this.lanes.add(Lane.defaultBacklog());
  }

  public KanbanBoardId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Lane> getLanes() {
    return lanes;
  }

  public void addLane(Lane lane) {
    this.lanes.add(lane);
  }

  public void removeLane(Lane lane) {
    this.lanes.remove(lane);
  }

  public void setId(KanbanBoardId id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
