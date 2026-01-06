package ch.schmucki.core.board;

import ch.schmucki.core.user.User;

public class WorkItem {
    private WorkItemId id;
    private User kanbanUser;
    private String name;
    private String description;
    private User owner;
    private User assignee;
    private IssueType issueType;
    private Lane lane;

    public WorkItem(String name, String description, User owner, IssueType issueType) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.issueType = issueType;
    }

    public void moveToNextLane(Lane lane) throws IllegalLaneStateException {
        if(this.lane.canBeMovedToLane(lane)) {
            this.lane = lane;
        } else {
            throw new IllegalLaneStateException(String.format("Cannot be moved to lane %s", lane.getTitle()));
        }
    }
}
