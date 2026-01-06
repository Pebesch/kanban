package ch.schmucki.core.board;

import java.util.ArrayList;
import java.util.List;

public class Lane {
    private String laneId;
    private String title;
    private int maxNumberOfItems;
    private List<Lane> nextLanes;
    private List<Lane> previousLanes;
    private List<WorkItem> workItems;

    public String getTitle() {
        return title;
    }

    public Lane(String title) {
        this.title = title;
        this.maxNumberOfItems = Integer.MAX_VALUE;
        this.nextLanes = new ArrayList<>();
        this.previousLanes = new ArrayList<>();
        this.workItems = new ArrayList<>();
    }

    public boolean canBeMovedToLane(Lane lane) {
        if(nextLanes.contains(lane) && lane.maxNumberOfItems < workItems.size()) {
            return true;
        };
        if(previousLanes.contains(lane) && lane.maxNumberOfItems > workItems.size()) {
            return true;
        }
        return false;
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
}
