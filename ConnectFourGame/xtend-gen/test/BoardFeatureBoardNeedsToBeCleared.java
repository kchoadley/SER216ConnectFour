package test;

import connect.four.board.Board;
import connect.four.player.Player;
import org.jnario.lib.Assert;
import org.jnario.lib.Should;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.BoardFeatureBackground;

@RunWith(FeatureRunner.class)
@Named("Scenario: Board needs to be Cleared")
@SuppressWarnings("all")
public class BoardFeatureBoardNeedsToBeCleared extends BoardFeatureBackground {
  @Test
  @Order(0)
  @Named("Given a player")
  public void _givenAPlayer() {
    super._givenAPlayer();
  }
  
  @Test
  @Order(1)
  @Named("Given any board")
  public void _givenAnyBoard() {
    Board _board = new Board(7, 6);
    this.board = _board;
    this.board.play(0, this.player);
    this.board.play(0, this.player);
    this.board.play(0, this.player);
    this.board.play(1, this.player);
    this.board.play(1, this.player);
    this.board.play(2, this.player);
  }
  
  @Test
  @Order(2)
  @Named("When the board is cleared")
  public void _whenTheBoardIsCleared() {
    Player _whoPlayed = this.board.whoPlayed(0, 0);
    boolean _doubleArrow = Should.<Player>operator_doubleArrow(_whoPlayed, this.player);
    Assert.assertTrue("\nExpected board.whoPlayed(0,0) => player but"
     + "\n     board.whoPlayed(0,0) is " + new org.hamcrest.StringDescription().appendValue(_whoPlayed).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     player is " + new org.hamcrest.StringDescription().appendValue(this.player).toString() + "\n", _doubleArrow);
    
    this.board.clear();
  }
  
  @Test
  @Order(3)
  @Named("Then all indexes should be null")
  public void _thenAllIndexesShouldBeNull() {
    for (int i = 0; (i < 7); i++) {
      for (int z = 0; (z < 6); z++) {
        Player _whoPlayed = this.board.whoPlayed(i, z);
        Assert.assertNull("\nExpected board.whoPlayed(i, z) => null\n     but is " + new org.hamcrest.StringDescription().appendValue(_whoPlayed).toString() + "\n", _whoPlayed);
        
      }
    }
  }
}
