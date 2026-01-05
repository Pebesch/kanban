package ch.schmucki.core.state;

import ch.schmucki.core.WorkItem;

public abstract class AbstractWorkItemState {
    WorkItem workItem;

    public AbstractWorkItemState(WorkItem workItem) {
        this.workItem = workItem;
    }

    public abstract State getState();

    public abstract void onBacklogState();

    public abstract void onSelectedState();

    public abstract void onProgressState();

    public abstract void onReviewState();

    public abstract void onDoneState();
}
