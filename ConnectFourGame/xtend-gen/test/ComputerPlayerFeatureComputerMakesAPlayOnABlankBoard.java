package test;

import com.google.common.base.Objects;
import connect.four.board.Board;
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
@Named("Scenario: Computer makes a play on a blank board")
@SuppressWarnings("all")
public class ComputerPlayerFeatureComputerMakesAPlayOnABlankBoard extends ComputerPlayerFeatureBackground {
  @Test
  @Order(0)
  @Named("Given a computer player and random generator")
  public void _givenAComputerPlayerAndRandomGenerator() {
    super._givenAComputerPlayerAndRandomGenerator();
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
  @Named("When the Computer makes a play")
  public void _whenTheComputerMakesAPlay() {
    this.player.performPlay(this.board);
  }
  
  @Test
  @Order(3)
  @Named("Then there should be a random space not null")
  public void _thenThereShouldBeARandomSpaceNotNull() {
    int nullcount = 0;
    for (int i = 0; (i < 7); i++) {
      for (int z = 0; (z < 6); z++) {
        Player _whoPlayed = this.board.whoPlayed(i, z);
        boolean _equals = Objects.equal(_whoPlayed, this.player);
        if (_equals) {
          nullcount++;
        }
      }
    }
    Assert.assertTrue("\nExpected nullcount should be 1 but"
     + "\n     nullcount is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(nullcount)).toString() + "\n", Should.<Integer>should_be(Integer.valueOf(nullcount), Integer.valueOf(1)));
    
  }
}
