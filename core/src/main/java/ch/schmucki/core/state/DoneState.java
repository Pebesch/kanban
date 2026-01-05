package ch.schmucki.core.state;

import ch.schmucki.core.WorkItem;

public class DoneState extends AbstractWorkItemState {
    public DoneState(WorkItem workItem) {
        super(workItem);
    }

    @Override
    public State getState() {
        return State.DONE;
    }

    @Override
    public void onBacklogState() {
        throw new IllegalStateException("BacklogState not allowed in DoneState");
    }

    @Override
    public void onSelectedState() {
        throw new IllegalStateException("SelectedState not allowed in DoneState");
    }

    @Override
    public void onProgressState() {
        throw new IllegalStateException("ProgressState not allowed in DoneState");
    }

    @Override
    public void onReviewState() {
        throw new IllegalStateException("ReviewState not allowed in DoneState");
    }

    @Override
    public void onDoneState() {
    }
}
