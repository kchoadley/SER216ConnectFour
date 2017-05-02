package test;

import connect.four.Game;
import connect.four.board.Board;
import connect.four.player.Player;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import test.GameFeature;

@RunWith(FeatureRunner.class)
@Named("Background:")
@SuppressWarnings("all")
public abstract class GameFeatureBackground extends GameFeature {
  Game game;
  
  Player player1;
  
  Player player2;
  
  Board board;
}
