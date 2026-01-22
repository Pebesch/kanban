package ch.schmucki.core.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lane {
    private LaneId id;
    private int ordinal;
    private final String title;
    private int maxNumberOfItems;
    private final List<Lane> nextLanes;
    private final List<Lane> previousLanes;
    private final List<WorkItem> workItems;

    public String getTitle() {
        return title;
    }

    public Lane(String title) {
        this.title = title;
        this.ordinal = 0;
        this.maxNumberOfItems = Integer.MAX_VALUE;
        this.nextLanes = new ArrayList<>();
        this.previousLanes = new ArrayList<>();
        this.workItems = new ArrayList<>();
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public void addWorkItem(WorkItem workItem) {
        workItems.add(workItem);
    }

    public List<WorkItem> getWorkItems() {
        return workItems;
    }

    public int getMaxNumberOfItems() {
        return maxNumberOfItems;
    }

    public void setMaxNumberOfItems(int maxNumberOfItems) {
        this.maxNumberOfItems = maxNumberOfItems;
    }

    public boolean canBeMovedToLane(Lane lane) {
        if (nextLanes.contains(lane) && lane.maxNumberOfItems < workItems.size()) {
            return true;
        };
        if (previousLanes.contains(lane) && lane.maxNumberOfItems > workItems.size()) {
            return true;
        }
        return false;
    }

    public void moveItemToLane(WorkItem workItem, Lane lane) {
        if(!canBeMovedToLane(lane)) {
            throw new IllegalArgumentException("Cannot move item to lane " + lane.getTitle());
        }
        workItems.remove(workItem);
        lane.addWorkItem(workItem);
    }

    public void addLaneToNext(Lane lane) {
        nextLanes.add(lane);
    }

    public void addLaneToPrevious(Lane lane) {
        this.previousLanes.add(lane);
    }

    public void removeLaneFromNext(Lane lane) {
        if(previousLanes.isEmpty()) {
            return;
        }
        nextLanes.remove(lane);
    }

    public void removeLaneFromPrevious(Lane lane) {
        previousLanes.remove(lane);
    }

    public static Lane defaultBacklog() {
        return new Lane("BACKLOG");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lane lane = (Lane) o;
        return maxNumberOfItems == lane.maxNumberOfItems && Objects.equals(id, lane.id) && Objects.equals(title, lane.title) && Objects.equals(nextLanes, lane.nextLanes) && Objects.equals(previousLanes, lane.previousLanes) && Objects.equals(workItems, lane.workItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, maxNumberOfItems, nextLanes, previousLanes, workItems);
    }
}
