package ch.schmucki.core.board;

public class IllegalLaneStateException extends Throwable {
    public IllegalLaneStateException(String reason) {
        super(reason);
    }
}
