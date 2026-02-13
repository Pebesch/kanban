package ch.schmucki.core.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KanbanBoardTest {
  KanbanBoard kanbanBoard;

  @BeforeEach
  void setUp() {
    this.kanbanBoard = new KanbanBoard();
  }

  @Test
  void getLanes() {
    assertEquals(1, kanbanBoard.getLanes().size());
    assertEquals("BACKLOG", kanbanBoard.getLanes().getFirst().getTitle());
  }

  @Test
  void addLane() {
    this.kanbanBoard.addLane(new Lane("TEST"));
    assertEquals(2, kanbanBoard.getLanes().size());
    assertEquals("TEST", kanbanBoard.getLanes().getLast().getTitle());
  }

  @Test
  void removeLane() {
    this.kanbanBoard.removeLane(Lane.defaultBacklog());
    assertEquals(0, kanbanBoard.getLanes().size());
  }
}
