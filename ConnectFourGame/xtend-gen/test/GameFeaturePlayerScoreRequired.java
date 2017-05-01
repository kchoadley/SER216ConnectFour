package test;

import connect.four.Game;
import connect.four.board.Board;
import connect.four.player.ConsolePlayer;
import connect.four.player.Player;
import org.jnario.lib.Assert;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.lib.StepArguments;
import org.jnario.lib.StringConversions;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.GameFeatureBackground;

@RunWith(FeatureRunner.class)
@Named("Scenario: Player score required")
@SuppressWarnings("all")
public class GameFeaturePlayerScoreRequired extends GameFeatureBackground {
  Player[] players = { this.player1, this.player2 };
  
  @Test
  @Order(0)
  @Named("Given a game and a board with scores set to \\\"5\\\" and \\\"4\\\"")
  public void _givenAGameAndABoardWithScoresSetTo5And4() {
    final StepArguments args = new StepArguments("5", "4");
    ConsolePlayer _consolePlayer = new ConsolePlayer("player1");
    this.player1 = _consolePlayer;
    ConsolePlayer _consolePlayer_1 = new ConsolePlayer("player2");
    this.player2 = _consolePlayer_1;
    this.players = new Player[] { this.player1, this.player2 };
    Board _board = new Board(7, 6);
    this.board = _board;
    Game _game = new Game(this.players, this.board, 4);
    this.game = _game;
    String _first = JnarioIterableExtensions.<String>first(args);
    int _int = StringConversions.toInt(_first);
    this.game.setScore(0, _int);
    String _second = JnarioIterableExtensions.<String>second(args);
    int _int_1 = StringConversions.toInt(_second);
    this.game.setScore(1, _int_1);
  }
  
  @Test
  @Order(1)
  @Named("Then they should return \\\"5\\\" and \\\"4\\\" respectively")
  public void _thenTheyShouldReturn5And4Respectively() {
    final StepArguments args = new StepArguments("5", "4");
    int _score = this.game.getScore(this.player1);
    String _first = JnarioIterableExtensions.<String>first(args);
    int _int = StringConversions.toInt(_first);
    boolean _should_be = Should.<Integer>should_be(Integer.valueOf(_score), Integer.valueOf(_int));
    Assert.assertTrue("\nExpected game.getScore(player1) should be args.first.toInt but"
     + "\n     game.getScore(player1) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_score)).toString()
     + "\n     game is " + new org.hamcrest.StringDescription().appendValue(this.game).toString()
     + "\n     player1 is " + new org.hamcrest.StringDescription().appendValue(this.player1).toString()
     + "\n     args.first.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int)).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _should_be);
    
    int _score_1 = this.game.getScore(this.player2);
    String _second = JnarioIterableExtensions.<String>second(args);
    int _int_1 = StringConversions.toInt(_second);
    Assert.assertTrue("\nExpected game.getScore(player2) should be args.second.toInt but"
     + "\n     game.getScore(player2) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_score_1)).toString()
     + "\n     game is " + new org.hamcrest.StringDescription().appendValue(this.game).toString()
     + "\n     player2 is " + new org.hamcrest.StringDescription().appendValue(this.player2).toString()
     + "\n     args.second.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int_1)).toString()
     + "\n     args.second is " + new org.hamcrest.StringDescription().appendValue(_second).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", Should.<Integer>should_be(Integer.valueOf(_score_1), Integer.valueOf(_int_1)));
    
  }
}
