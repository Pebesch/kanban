package ch.schmucki.core.state;

import ch.schmucki.core.WorkItem;

public class ProgressState extends AbstractWorkItemState {
    public ProgressState(WorkItem workItem) {
        super(workItem);
    }

    @Override
    public State getState() {
        return State.PROGRESS;
    }

    @Override
    public void onBacklogState() {
        workItem.changeWorkItemState(new BacklogState(workItem));
    }

    @Override
    public void onSelectedState() {
        workItem.changeWorkItemState(new SelectedState(workItem));
    }

    @Override
    public void onProgressState() {

    }

    @Override
    public void onReviewState() {
        workItem.changeWorkItemState(new ReviewState(workItem));
    }

    @Override
    public void onDoneState() {
        throw new IllegalStateException("DoneState not allowed in ProgressState");
    }
}
