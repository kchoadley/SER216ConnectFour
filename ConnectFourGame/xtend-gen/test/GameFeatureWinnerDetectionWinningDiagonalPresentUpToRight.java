package test;

import connect.four.Game;
import connect.four.board.Board;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;
import org.jnario.lib.Assert;
import org.jnario.lib.Should;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.GameFeatureBackground;

@RunWith(FeatureRunner.class)
@Named("Scenario: Winner Detection - winning diagonal present - Up to right")
@SuppressWarnings("all")
public class GameFeatureWinnerDetectionWinningDiagonalPresentUpToRight extends GameFeatureBackground {
  Player[] players = { this.player1, this.player2 };
  
  @Test
  @Order(0)
  @Named("Given a game with a winning upright diagonal present")
  public void _givenAGameWithAWinningUprightDiagonalPresent() {
    ConsolePlayer _consolePlayer = new ConsolePlayer("player1");
    this.player1 = _consolePlayer;
    ConsolePlayer _consolePlayer_1 = new ConsolePlayer("player2");
    this.player2 = _consolePlayer_1;
    this.players = new Player[] { this.player1, this.player2 };
    Board _board = new Board(7, 6);
    this.board = _board;
    Game _game = new Game(this.players, this.board, 4);
    this.game = _game;
    this.board.play(0, this.player1);
    this.board.play(1, this.player2);
    this.board.play(1, this.player1);
    this.board.play(2, this.player2);
    this.board.play(2, this.player2);
    this.board.play(2, this.player1);
    this.board.play(3, this.player2);
    this.board.play(3, this.player2);
    this.board.play(3, this.player2);
    this.board.play(3, this.player1);
  }
  
  @Test
  @Order(1)
  @Named("Then game should return player1 winner")
  public void _thenGameShouldReturnPlayer1Winner() {
    Player _detectWinner = Game.detectWinner(this.board, 4);
    Assert.assertTrue("\nExpected Game.detectWinner(board, 4) should be player1 but"
     + "\n     Game.detectWinner(board, 4) is " + new org.hamcrest.StringDescription().appendValue(_detectWinner).toString()
     + "\n     Game is " + new org.hamcrest.StringDescription().appendValue(Game.class).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     player1 is " + new org.hamcrest.StringDescription().appendValue(this.player1).toString() + "\n", Should.<Player>should_be(_detectWinner, this.player1));
    
  }
}
