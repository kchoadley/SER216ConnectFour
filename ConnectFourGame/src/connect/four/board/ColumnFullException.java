package connect.four.board;

public class ColumnFullException extends IndexOutOfBoundsException {
	private static final long serialVersionUID = -7872390963310427712L;
	public ColumnFullException() {
    	super("Played in a full column.");
    }
    public ColumnFullException(String message) {
    	super(message);
    }
}
