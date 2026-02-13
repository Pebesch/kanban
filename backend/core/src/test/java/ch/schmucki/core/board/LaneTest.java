package ch.schmucki.core.board;

import static org.junit.jupiter.api.Assertions.*;

import ch.schmucki.core.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LaneTest {
  Lane defaultLane;
  User defaultUser;

  @BeforeEach
  void setUp() {
    defaultLane = new Lane("DEFAULT");
    defaultUser = new User();
  }

  @Test
  void addWorkItem() {
    var item = new WorkItem("Task 1", "", defaultUser, IssueType.TASK);
    this.defaultLane.addWorkItem(item);
    assertEquals(1, this.defaultLane.getWorkItems().size());
  }

  @Test
  void canBeMovedToLane() {
    var progress = new Lane("PROGRESS");
    defaultLane.addLaneToNext(progress);
    var task = new WorkItem("Task 1", "", defaultUser, IssueType.TASK);
    defaultLane.addWorkItem(task);
    assertTrue(defaultLane.canBeMovedToLane(progress));
  }

  @Test
  void canNotBeMovedToLane_max_number_of_items_reached() {
    var progress = new Lane("PROGRESS");
    progress.setMaxNumberOfItems(0);
    defaultLane.addLaneToNext(progress);
    var task = new WorkItem("Task 1", "", defaultUser, IssueType.TASK);
    defaultLane.addWorkItem(task);
    assertFalse(defaultLane.canBeMovedToLane(progress));
  }

  @Test
  void canNotBeMovedToLane_lane_not_in_next() {
    var progress = new Lane("PROGRESS");
    var task = new WorkItem("Task 1", "", defaultUser, IssueType.TASK);
    defaultLane.addWorkItem(task);
    assertFalse(defaultLane.canBeMovedToLane(progress));
  }

  @Test
  void canBeMovedToPreviousLane() {
    var progress = new Lane("PROGRESS");
    defaultLane.addLaneToPrevious(progress);
    var task = new WorkItem("Task 1", "", defaultUser, IssueType.TASK);
    defaultLane.addWorkItem(task);
    assertTrue(defaultLane.canBeMovedToLane(progress));
  }
}
