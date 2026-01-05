package ch.schmucki.core.state;

import ch.schmucki.core.WorkItem;

public class BacklogState extends AbstractWorkItemState {
    public BacklogState(WorkItem workItem) {
        super(workItem);
    }

    @Override
    public State getState() {
        return State.BACKLOG;
    }

    @Override
    public void onBacklogState() {
    }

    @Override
    public void onSelectedState() {
        workItem.changeWorkItemState(new SelectedState(workItem));
    }

    @Override
    public void onProgressState() {
        throw new IllegalStateException("ProgressState not allowed in BacklogState");
    }

    @Override
    public void onReviewState() {
        throw new IllegalStateException("ReviewState not allowed in BacklogState");
    }

    @Override
    public void onDoneState() {
        workItem.changeWorkItemState(new DoneState(workItem));
    }
}
