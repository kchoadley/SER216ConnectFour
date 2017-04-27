
package connect.four;

import connect.four.player.Player;
import connect.four.board.ReadableBoard;
import connect.four.board.ReadWritableBoard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Game implements ScoreChart {
    Player[] m_players;
    int[] m_scores; // since when is there a score in connect four?
    List<ScoreChart.Listener> m_listeners;
    ReadWritableBoard m_board;
    int m_inRow; // why track row?
    int m_currentPlayer;
    
    public Game(Player[] players, ReadWritableBoard board, int inRow) {
        m_players = Arrays.copyOf(players, players.length);	// why make a copy?
        m_scores = new int[players.length]; // is there a case where there are more or less than 2 players?
        m_listeners = new ArrayList<ScoreChart.Listener>();
        m_board = board;
        m_inRow = inRow;
    }
    public void start() {
        int first = (new Random()).nextInt(m_players.length);
        performPlay(first);
    }
    @Override public void registerListener(ScoreChart.Listener l) {
        m_listeners.add(l);
    }
    @Override public void unregisterListener(ScoreChart.Listener l) {
        m_listeners.remove(l);
    }
    @Override public List<Player> getPlayers() {
        return Arrays.asList(m_players);
    }
    @Override public int getScore(Player p) {
        int pos = -1;
        int l = m_players.length;
        for (int i = 0; i != l; ++i) {
            if (m_players[i] == p) pos = i;
        }
        return m_scores[pos];
    }
    void performPlay(final int player) {
        m_currentPlayer = player;
        ReadWritableBoard controlledBoard = new ReadWritableBoard() {
            boolean played;
            @Override public Player whoPlayed(int x, int y) {
                return m_board.whoPlayed(x, y);
            }
            @Override public void play(int x, Player p) {
                if (played) {
                    throw new Error(p+" Played more than once in a turn.");
                }
                played = true;
                m_board.play(x, p);
                Player win = detectWinner(m_board, m_inRow);
                if (win != null) {
                    m_scores[player] += 1;
                    for (ScoreChart.Listener l : m_listeners) {
                        l.gameOver(win, Game.this, m_board);
                    }
                    m_board.clear();
                    performPlay(player);
                } 
                else if (m_board.getMoveCount() == m_board.getWidth()*m_board.getHeight() ) {
                    for (ScoreChart.Listener l : m_listeners) {
                        l.gameOver(null, Game.this, m_board);
                    }
                    m_board.clear();
                    performPlay((player+1) % m_players.length);
                } 
                else {
                    performPlay((player+1) % m_players.length);
                }
            }
            @Override 
            public void clear() {
                m_board.clear();
            }
            @Override 
            public int getWidth() {
                return m_board.getWidth();
            }
            @Override 
            public int getHeight() {
                return m_board.getHeight();
            }
            @Override public int getColumnHeight(int x) {
			return m_board.getColumnHeight(x);
		    }
		    @Override public int getMoveCount() {
			return m_board.getMoveCount();
		    }
        };
        m_players[player].performPlay(controlledBoard);
    }
    
    public Player getCurrentPlayer(){
            return m_players[m_currentPlayer];
    }

    public int getInRow() {
	return m_inRow;
    }

    public ReadableBoard getBoard() {
	return m_board;
    }

    public static Player detectWinner(ReadableBoard board, int inRow) {
    	// inRow is how many tokens should be in a row in order to win. Only called with inRow of 4.
    	if(board.getMoveCount()<(inRow*2-1))		// not enough moves to have a winner yet
    		return null;
        int width = board.getWidth();
        int height = board.getHeight();
        
        // check columns for winner
        // would be easy to make more efficient by continuing to next column if a null space is found
        for (int i = 0; i < width; ++i) {				
            Player possible = null;
            int found = 0;
            for (int j = 0; j < height; ++j) {
                if (possible == null) {		// no longer possible to have a win in this column, move on to next column
                	j=height;
                } 
                else if (board.whoPlayed(i, j) == possible) {
                    found += 1;
                    if (found == inRow) {
                        return possible;
                    }
                }
                else {
                    found = 1;
                    possible = board.whoPlayed(i, j);
                }
            }
        }
        
        // check rows for winner
        for (int i = 0; i < height; ++i) {
            Player possible = null;
            int found = 0;
            for (int j = 0; j < width; ++j) {
                if (board.whoPlayed(j, i) == possible && possible != null) {
                    found += 1;
                }
                else if(j > width-inRow+1) // no longer possible to have a win in this row, move on to next row
                	j=width;
                else {
                    found = 1;
                    possible = board.whoPlayed(j, i);
                }
                if (found == inRow) {
                    return possible;
                }
            }
        }
        
        // checks diagonals going from bottom left to top right. First location checked is top left corner position
        // adjusted i to start at first diagonal that could contain a win and end on last diagonal that could contain a win
        for (int i = inRow-height; i < width-inRow+1; ++i) {
            Player possible = null;
            int found = 0;
		   	for (int j = 0; j < height; ++j) {
				int k = j+i;
				if (k >= 0 && k < width) {
	                if (board.whoPlayed(k, j) == possible && possible != null) {
	                    found += 1;
	                } 
	                else if(j > height-inRow+1) // no longer possible to have a win in this diagonal, move on to next diagonal
	                	j=height;
	                else {
	                    found = 1;
	                    possible = board.whoPlayed(k, j);
	                }
	                if (found == inRow) {
	                    return possible;
	                }
				}
		    }
		}

        // checks diagonals from bottom right to top left. Starts at top right space on board.
        // adjusted i to start at first diagonal that could contain a win and end on last diagonal that could contain a win
        for (int i = inRow-height; i < width-inRow+1; ++i) {
            Player possible = null;
            int found = 0;
		    for (int j = 0; j < height; ++j) {
		    	int k = j+i;
		    	if (k >= 0 && k < width) {
                    if (board.whoPlayed(width-k-1, j) == possible && possible != null) {
                        found += 1;
                    } 
                    else if(j > height-inRow+1)	// no longer possible to have a win in this diagonal, move on to next diagonal
                    	j=height;
                    else {
                        found = 1;
                        possible = board.whoPlayed(width-k-1, j);
                    }
                    if (found == inRow) {
                        return possible;
                    }
				}
		    }
        }
        return null;
    }
}
