package test;

import connect.four.board.Board;
import connect.four.player.Player;
import org.jnario.lib.Assert;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.lib.StepArguments;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.BoardFeatureBackground;

@RunWith(FeatureRunner.class)
@Named("Scenario: Playing a piece")
@SuppressWarnings("all")
public class BoardFeaturePlayingAPiece extends BoardFeatureBackground {
  @Test
  @Order(0)
  @Named("Given a player")
  public void _givenAPlayer() {
    super._givenAPlayer();
  }
  
  @Test
  @Order(1)
  @Named("Given A blank board")
  public void _givenABlankBoard() {
    Board _board = new Board(7, 6);
    this.board = _board;
  }
  
  @Test
  @Order(2)
  @Named("When board recieves a move")
  public void _whenBoardRecievesAMove() {
    this.board.play(1, this.player);
    this.board.play(1, this.player);
  }
  
  @Test
  @Order(3)
  @Named("Then \\\"Test\\\" should be the name at location")
  public void _thenTestShouldBeTheNameAtLocation() {
    final StepArguments args = new StepArguments("Test");
    Player _whoPlayed = this.board.whoPlayed(1, 0);
    String _name = _whoPlayed.getName();
    String _first = JnarioIterableExtensions.<String>first(args);
    boolean _doubleArrow = Should.<String>operator_doubleArrow(_name, _first);
    Assert.assertTrue("\nExpected board.whoPlayed(1,0).getName() => args.first but"
     + "\n     board.whoPlayed(1,0).getName() is " + new org.hamcrest.StringDescription().appendValue(_name).toString()
     + "\n     board.whoPlayed(1,0) is " + new org.hamcrest.StringDescription().appendValue(_whoPlayed).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _doubleArrow);
    
    Player _whoPlayed_1 = this.board.whoPlayed(1, 1);
    String _name_1 = _whoPlayed_1.getName();
    String _first_1 = JnarioIterableExtensions.<String>first(args);
    Assert.assertTrue("\nExpected board.whoPlayed(1,1).getName() => args.first but"
     + "\n     board.whoPlayed(1,1).getName() is " + new org.hamcrest.StringDescription().appendValue(_name_1).toString()
     + "\n     board.whoPlayed(1,1) is " + new org.hamcrest.StringDescription().appendValue(_whoPlayed_1).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first_1).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", Should.<String>operator_doubleArrow(_name_1, _first_1));
    
  }
}
