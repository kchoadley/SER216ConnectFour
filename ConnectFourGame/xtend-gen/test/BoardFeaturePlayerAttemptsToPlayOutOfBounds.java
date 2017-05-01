package test;

import connect.four.board.Board;
import org.jnario.lib.Assert;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.BoardFeatureBackground;

@RunWith(FeatureRunner.class)
@Named("Scenario: Player attempts to play out of bounds")
@SuppressWarnings("all")
public class BoardFeaturePlayerAttemptsToPlayOutOfBounds extends BoardFeatureBackground {
  @Test
  @Order(0)
  @Named("Given a player")
  public void _givenAPlayer() {
    super._givenAPlayer();
  }
  
  @Test
  @Order(1)
  @Named("Given a board")
  public void _givenABoard() {
    Board _board = new Board(7, 6);
    this.board = _board;
  }
  
  @Test
  @Order(2)
  @Named("When board recieves an invalid move")
  public void _whenBoardRecievesAnInvalidMove() {
    boolean expectedException = false;
    String message = "";
    try{
      this.board.play(7, this.player);
      message = "Expected " + ArrayIndexOutOfBoundsException.class.getName() + " for \n     board.play(7, player)\n with:"
       + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
       + "\n     player is " + new org.hamcrest.StringDescription().appendValue(this.player).toString();
    }catch(ArrayIndexOutOfBoundsException e){
      expectedException = true;
    }
    Assert.assertTrue(message, expectedException);
    boolean expectedException_1 = false;
    String message_1 = "";
    try{
      this.board.play((-1), this.player);
      message_1 = "Expected " + ArrayIndexOutOfBoundsException.class.getName() + " for \n     board.play(-1, player)\n with:"
       + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
       + "\n     -1 is " + new org.hamcrest.StringDescription().appendValue((-1)).toString()
       + "\n     player is " + new org.hamcrest.StringDescription().appendValue(this.player).toString();
    }catch(ArrayIndexOutOfBoundsException e){
      expectedException_1 = true;
    }
    Assert.assertTrue(message_1, expectedException_1);
  }
}
