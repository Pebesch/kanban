package ch.schmucki.core;

import ch.schmucki.core.state.AbstractWorkItemState;
import ch.schmucki.core.state.BacklogState;

public class WorkItem {
    private String name;
    private String description;
    private AbstractWorkItemState state;
    private User owner;
    private User assignee;
    private IssueType issueType;

    public WorkItem(String name, String description, User owner, IssueType issueType) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.issueType = issueType;
        this.state = new BacklogState(this);
    }

    public void changeWorkItemState(AbstractWorkItemState state) {
        this.state = state;
    }

    public AbstractWorkItemState getState() {
        return state;
    }
}
