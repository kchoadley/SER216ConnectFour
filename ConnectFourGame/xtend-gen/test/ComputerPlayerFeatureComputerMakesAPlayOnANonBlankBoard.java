package test;

import com.google.common.base.Objects;
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
import test.ComputerPlayerFeatureBackground;

@RunWith(FeatureRunner.class)
@Named("Scenario: Computer makes a play on a non-blank board")
@SuppressWarnings("all")
public class ComputerPlayerFeatureComputerMakesAPlayOnANonBlankBoard extends ComputerPlayerFeatureBackground {
  @Test
  @Order(0)
  @Named("Given a computer player and random generator")
  public void _givenAComputerPlayerAndRandomGenerator() {
    super._givenAComputerPlayerAndRandomGenerator();
  }
  
  @Test
  @Order(1)
  @Named("Given a non-blank board and second player")
  public void _givenANonBlankBoardAndSecondPlayer() {
    ConsolePlayer _consolePlayer = new ConsolePlayer("Player2");
    this.player2 = _consolePlayer;
    Board _board = new Board(7, 6);
    this.board = _board;
    int _nextInt = this.randomGen.nextInt(7);
    this.board.play(_nextInt, this.player2);
    int _nextInt_1 = this.randomGen.nextInt(7);
    this.board.play(_nextInt_1, this.player2);
    int _nextInt_2 = this.randomGen.nextInt(7);
    this.board.play(_nextInt_2, this.player2);
    int _nextInt_3 = this.randomGen.nextInt(7);
    this.board.play(_nextInt_3, this.player2);
    int _nextInt_4 = this.randomGen.nextInt(7);
    this.board.play(_nextInt_4, this.player2);
  }
  
  @Test
  @Order(2)
  @Named("When the Computer makes its play")
  public void _whenTheComputerMakesItsPlay() {
    this.player.performPlay(this.board);
  }
  
  @Test
  @Order(3)
  @Named("Then there should be a computer placed piece")
  public void _thenThereShouldBeAComputerPlacedPiece() {
    int computerPlays = 0;
    for (int i = 0; (i < 7); i++) {
      for (int z = 0; (z < 6); z++) {
        Player _whoPlayed = this.board.whoPlayed(i, z);
        boolean _equals = Objects.equal(_whoPlayed, this.player);
        if (_equals) {
          computerPlays++;
        }
      }
    }
    Assert.assertFalse("\nExpected computerPlays should not be 0 but"
     + "\n     computerPlays is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(computerPlays)).toString() + "\n", Should.<Integer>should_be(Integer.valueOf(computerPlays), Integer.valueOf(0)));
    
  }
}
