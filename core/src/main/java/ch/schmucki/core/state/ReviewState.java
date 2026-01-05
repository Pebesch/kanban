package ch.schmucki.core.state;

import ch.schmucki.core.WorkItem;

public class ReviewState extends AbstractWorkItemState {
    public ReviewState(WorkItem workItem) {
        super(workItem);
    }

    @Override
    public State getState() {
        return State.REVIEW;
    }

    @Override
    public void onBacklogState() {
        throw new IllegalStateException("BacklogState not allowed in ReviewState");
    }

    @Override
    public void onSelectedState() {
        throw new IllegalStateException("SelectedState not allowed in ReviewState");
    }

    @Override
    public void onProgressState() {
        workItem.changeWorkItemState(new ProgressState(workItem));
    }

    @Override
    public void onReviewState() {

    }

    @Override
    public void onDoneState() {
        workItem.changeWorkItemState(new DoneState(workItem));
    }
}
