package connect.four.board;

import connect.four.player.Player;

public interface WritableBoard { //only referenced in ReadWritableBoard. Could remove, include functionality in ReadWritableBoard.
    void play(int x, Player p);
    void clear();
}
