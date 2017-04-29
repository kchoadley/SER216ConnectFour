package test;

import connect.four.board.Board;
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
import test.BoardFeatureBackground;

@RunWith(FeatureRunner.class)
@Named("Scenario: Board Column Height Check - Not empty Columns")
@SuppressWarnings("all")
public class BoardFeatureBoardColumnHeightCheckNotEmptyColumns extends BoardFeatureBackground {
  @Test
  @Order(0)
  @Named("Given a player")
  public void _givenAPlayer() {
    super._givenAPlayer();
  }
  
  @Test
  @Order(1)
  @Named("Given a board with columns filled 321000")
  public void _givenABoardWithColumnsFilled321000() {
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
  @Named("Then height should be \\\"3\\\" \\\"2\\\" \\\"1\\\" respectively")
  public void _thenHeightShouldBe321Respectively() {
    final StepArguments args = new StepArguments("3", "2", "1");
    int _columnHeight = this.board.getColumnHeight(0);
    String _first = JnarioIterableExtensions.<String>first(args);
    int _int = StringConversions.toInt(_first);
    boolean _doubleArrow = Should.<Integer>operator_doubleArrow(Integer.valueOf(_columnHeight), Integer.valueOf(_int));
    Assert.assertTrue("\nExpected board.getColumnHeight(0) => args.first.toInt but"
     + "\n     board.getColumnHeight(0) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_columnHeight)).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.first.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int)).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _doubleArrow);
    
    int _columnHeight_1 = this.board.getColumnHeight(1);
    String _second = JnarioIterableExtensions.<String>second(args);
    int _int_1 = StringConversions.toInt(_second);
    boolean _doubleArrow_1 = Should.<Integer>operator_doubleArrow(Integer.valueOf(_columnHeight_1), Integer.valueOf(_int_1));
    Assert.assertTrue("\nExpected board.getColumnHeight(1) => args.second.toInt but"
     + "\n     board.getColumnHeight(1) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_columnHeight_1)).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.second.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int_1)).toString()
     + "\n     args.second is " + new org.hamcrest.StringDescription().appendValue(_second).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _doubleArrow_1);
    
    int _columnHeight_2 = this.board.getColumnHeight(2);
    String _third = JnarioIterableExtensions.<String>third(args);
    int _int_2 = StringConversions.toInt(_third);
    Assert.assertTrue("\nExpected board.getColumnHeight(2) => args.third.toInt but"
     + "\n     board.getColumnHeight(2) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_columnHeight_2)).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.third.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int_2)).toString()
     + "\n     args.third is " + new org.hamcrest.StringDescription().appendValue(_third).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", Should.<Integer>operator_doubleArrow(Integer.valueOf(_columnHeight_2), Integer.valueOf(_int_2)));
    
  }
}
