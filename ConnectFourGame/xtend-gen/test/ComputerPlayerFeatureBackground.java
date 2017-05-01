package test;

import connect.four.board.Board;
import connect.four.player.ComputerPlayer;
import connect.four.player.ConsolePlayer;
import java.util.Random;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.ComputerPlayerFeature;

@RunWith(FeatureRunner.class)
@Named("Background:")
@SuppressWarnings("all")
public abstract class ComputerPlayerFeatureBackground extends ComputerPlayerFeature {
  Board board;
  
  ComputerPlayer player;
  
  ConsolePlayer player2;
  
  Random randomGen;
  
  @Test
  @Order(0)
  @Named("Given a computer player and random generator")
  public void _givenAComputerPlayerAndRandomGenerator() {
    ComputerPlayer _computerPlayer = new ComputerPlayer();
    this.player = _computerPlayer;
    Random _random = new Random();
    this.randomGen = _random;
  }
}
