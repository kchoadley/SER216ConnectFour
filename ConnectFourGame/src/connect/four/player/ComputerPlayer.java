
package connect.four.player;

import connect.four.board.Board;
import connect.four.board.ReadableBoard;
import connect.four.board.ReadWritableBoard;
import connect.four.Game;
import java.util.Arrays;
import java.util.Random;


public class ComputerPlayer implements Player {
    int m_depth;	// depth should be even
    public ComputerPlayer() {
        m_depth = 4;
    }
    public ComputerPlayer(int depth) {
        m_depth = depth;
    }
    @Override public String getName() {
        return "Computer";
    }

    @Override public void performPlay(ReadWritableBoard board) {
        int l = board.getWidth();
        int m = board.getHeight();
        if (board.getMoveCount() == 0) {
            board.play((new Random()).nextInt(l), this);
        } 
        else {
            Player opponent = getOpponent(board);
            int maxMove = (new Random()).nextInt(l);
            long maxScore = Integer.MIN_VALUE;
            long[] scores = new long[l];
            for (int i = 0; i != l; ++i) {
                if (board.whoPlayed(i, m-1) != null) continue;
                long iScore = scoreMoveMinMax(i, m_depth, board, opponent);
                if (iScore > maxScore) {
                    maxMove = i;
                    maxScore = iScore;
                }
                scores[i] = iScore;
            }
		    while (board.whoPlayed(maxMove, m-1) != null) {
	                maxMove = (maxMove+1)%l;
		    }
            System.out.println(Arrays.toString(scores));	// leave me in. I show the rating given to each column. Higher is better.
            board.play(maxMove, this);
        }
    }
    
    // Left in old score move (lightly edited) with comments to clarify how it worked and why I changed it
    @SuppressWarnings("unused")
	private long scoreMove(int x, int depth, ReadableBoard board, Player opponent) {
    	if(depth <= 0)
    		return 0;
        int m = board.getHeight();								// initialize m to board height
        if (board.whoPlayed(x, m-1) != null) return 0;			// This checks for full column, returns zero
        Board myMove = new Board(board);						// create new board to perform move on
        myMove.play(x, this);									// put token in column x
        int l = myMove.getWidth();								// sets l to width of board
        long score = 0;											// initialize score
        if (Game.detectWinner(myMove, 4) != null) {
            score += Math.pow(l, depth);						// the sooner the win is possible, the higher the score for the move
        } 
        else {
            for (int i = 0; i != l; ++i) {						// selects column for opponent to play token
                if (myMove.whoPlayed(i, m-1) != null) continue;	// if column full, continue
                Board nextMove = new Board(myMove);				// new board for next move
                nextMove.play(i, opponent);
                if (Game.detectWinner(nextMove, 4) == opponent) {	// @arg 4, the number of tokens in a row in order to win
                	score -= Math.pow(l, depth-1);
                } 
                else {
                    for (int j = 0; j != l; ++j) {
                        score += scoreMove(j, depth - 2, nextMove, opponent);
                    }
                }
            }
        }
        return score;
    }

    private long scoreMoveMinMax(int x, int depth, ReadableBoard board, Player opponent) {
    	if(depth <= 0)
    		return 0;
        int m = board.getHeight();								// initialize m to board height
        if (board.whoPlayed(x, m-1) != null) return 0;			// This checks for full column, returns zero
        Board myMove = new Board(board);						// create new board to perform move on
        myMove.play(x, this);									// put token in column x
        int l = myMove.getWidth();								// sets l to width of board
        long score = 0;											// initialize score
        
        // see if computer wins
        if (Game.detectWinner(myMove, 4) == this) {
            score += Math.pow(l, depth);						// the sooner the win is possible, the higher the score for the move
            return score;
        } 
        
        // determine if player could win next turn, assumes smart player
        for (int i = 0; i != l; ++i) {				// selects column for opponent to play token
            if (myMove.whoPlayed(i, m-1) != null) continue;	// if column full, continue
            Board nextMove = new Board(myMove);				// new board for next move
            nextMove.play(i, opponent);
            if (Game.detectWinner(nextMove, 4) == opponent) {	// @arg 4, the number of tokens in a row in order to win
            	score -= Math.pow(l, depth-1);
            	return score;
            } 
        }
        
        // check each next two turns
        for (int i = 0; i != l; ++i) {				// selects column for opponent to play token
            if (myMove.whoPlayed(i, m-1) != null) continue;	// if column full, continue
            Board nextMove = new Board(myMove);				// new board for next move
            nextMove.play(i, opponent);
            for (int j = l-1; j != 0; --j) {
                score += scoreMoveMinMax(j, depth - 2, nextMove, opponent);
            }
        }
        return score;
    }

    private Player getOpponent(ReadableBoard board) {
        int l = board.getWidth();
        int m = board.getHeight();
        for (int i = 0; i != l; ++i) {
            for (int j = 0; j != m; ++j) {
                Player here = board.whoPlayed(i, j);
                if (here != null && here != this) {
                    return here;
                }
            }
        }
        throw new Error("Can't call getOpponent on first turn.");
    }
}
