package connect.four.board;

public class ColumnFullException extends IndexOutOfBoundsException {
    public ColumnFullException() {
    	super("Played in a full column.");
    }
    public ColumnFullException(String message) {
    	super(message);
    }
}
