package ch.schmucki.core.state;

import ch.schmucki.core.WorkItem;

public class SelectedState extends AbstractWorkItemState {
    public SelectedState(WorkItem workItem) {
        super(workItem);
    }

    @Override
    public State getState() {
        return State.SELECTED;
    }

    @Override
    public void onBacklogState() {
        workItem.changeWorkItemState(new BacklogState(workItem));
    }

    @Override
    public void onSelectedState() {

    }

    @Override
    public void onProgressState() {
        workItem.changeWorkItemState(new ProgressState(workItem));
    }

    @Override
    public void onReviewState() {
        throw new IllegalArgumentException("ReviewState not allowed in SelectedState");
    }

    @Override
    public void onDoneState() {
        workItem.changeWorkItemState(new DoneState(workItem));
    }
}
