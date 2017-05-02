package test;

import connect.four.board.Board;
import connect.four.player.ConsolePlayer;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.BoardFeature;

@RunWith(FeatureRunner.class)
@Named("Background:")
@SuppressWarnings("all")
public abstract class BoardFeatureBackground extends BoardFeature {
  Board board;
  
  ConsolePlayer player;
  
  @Test
  @Order(0)
  @Named("Given a player")
  public void _givenAPlayer() {
    ConsolePlayer _consolePlayer = new ConsolePlayer("Test");
    this.player = _consolePlayer;
  }
}
