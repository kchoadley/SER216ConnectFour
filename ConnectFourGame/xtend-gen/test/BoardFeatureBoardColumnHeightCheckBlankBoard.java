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
@Named("Scenario: Board Column Height Check - Blank Board")
@SuppressWarnings("all")
public class BoardFeatureBoardColumnHeightCheckBlankBoard extends BoardFeatureBackground {
  @Test
  @Order(0)
  @Named("Given a player")
  public void _givenAPlayer() {
    super._givenAPlayer();
  }
  
  @Test
  @Order(1)
  @Named("Given a blank board")
  public void _givenABlankBoard() {
    Board _board = new Board(7, 6);
    this.board = _board;
  }
  
  @Test
  @Order(2)
  @Named("Then height should be \\\"0\\\"")
  public void _thenHeightShouldBe0() {
    final StepArguments args = new StepArguments("0");
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
    String _first_1 = JnarioIterableExtensions.<String>first(args);
    int _int_1 = StringConversions.toInt(_first_1);
    boolean _doubleArrow_1 = Should.<Integer>operator_doubleArrow(Integer.valueOf(_columnHeight_1), Integer.valueOf(_int_1));
    Assert.assertTrue("\nExpected board.getColumnHeight(1) => args.first.toInt but"
     + "\n     board.getColumnHeight(1) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_columnHeight_1)).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.first.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int_1)).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first_1).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _doubleArrow_1);
    
    int _columnHeight_2 = this.board.getColumnHeight(2);
    String _first_2 = JnarioIterableExtensions.<String>first(args);
    int _int_2 = StringConversions.toInt(_first_2);
    boolean _doubleArrow_2 = Should.<Integer>operator_doubleArrow(Integer.valueOf(_columnHeight_2), Integer.valueOf(_int_2));
    Assert.assertTrue("\nExpected board.getColumnHeight(2) => args.first.toInt but"
     + "\n     board.getColumnHeight(2) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_columnHeight_2)).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.first.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int_2)).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first_2).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _doubleArrow_2);
    
    int _columnHeight_3 = this.board.getColumnHeight(3);
    String _first_3 = JnarioIterableExtensions.<String>first(args);
    int _int_3 = StringConversions.toInt(_first_3);
    boolean _doubleArrow_3 = Should.<Integer>operator_doubleArrow(Integer.valueOf(_columnHeight_3), Integer.valueOf(_int_3));
    Assert.assertTrue("\nExpected board.getColumnHeight(3) => args.first.toInt but"
     + "\n     board.getColumnHeight(3) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_columnHeight_3)).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.first.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int_3)).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first_3).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _doubleArrow_3);
    
    int _columnHeight_4 = this.board.getColumnHeight(4);
    String _first_4 = JnarioIterableExtensions.<String>first(args);
    int _int_4 = StringConversions.toInt(_first_4);
    boolean _doubleArrow_4 = Should.<Integer>operator_doubleArrow(Integer.valueOf(_columnHeight_4), Integer.valueOf(_int_4));
    Assert.assertTrue("\nExpected board.getColumnHeight(4) => args.first.toInt but"
     + "\n     board.getColumnHeight(4) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_columnHeight_4)).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.first.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int_4)).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first_4).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _doubleArrow_4);
    
    int _columnHeight_5 = this.board.getColumnHeight(5);
    String _first_5 = JnarioIterableExtensions.<String>first(args);
    int _int_5 = StringConversions.toInt(_first_5);
    boolean _doubleArrow_5 = Should.<Integer>operator_doubleArrow(Integer.valueOf(_columnHeight_5), Integer.valueOf(_int_5));
    Assert.assertTrue("\nExpected board.getColumnHeight(5) => args.first.toInt but"
     + "\n     board.getColumnHeight(5) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_columnHeight_5)).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.first.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int_5)).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first_5).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _doubleArrow_5);
    
    int _columnHeight_6 = this.board.getColumnHeight(6);
    String _first_6 = JnarioIterableExtensions.<String>first(args);
    int _int_6 = StringConversions.toInt(_first_6);
    boolean _doubleArrow_6 = Should.<Integer>operator_doubleArrow(Integer.valueOf(_columnHeight_6), Integer.valueOf(_int_6));
    Assert.assertTrue("\nExpected board.getColumnHeight(6) => args.first.toInt but"
     + "\n     board.getColumnHeight(6) is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_columnHeight_6)).toString()
     + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
     + "\n     args.first.toInt is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(_int_6)).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first_6).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _doubleArrow_6);
    
    boolean expectedException = false;
    String message = "";
    try{
      this.board.getColumnHeight((-1));
      message = "Expected " + ArrayIndexOutOfBoundsException.class.getName() + " for \n     board.getColumnHeight(-1)\n with:"
       + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString()
       + "\n     -1 is " + new org.hamcrest.StringDescription().appendValue((-1)).toString();
    }catch(ArrayIndexOutOfBoundsException e){
      expectedException = true;
    }
    Assert.assertTrue(message, expectedException);
    boolean expectedException_1 = false;
    String message_1 = "";
    try{
      this.board.getColumnHeight(7);
      message_1 = "Expected " + ArrayIndexOutOfBoundsException.class.getName() + " for \n     board.getColumnHeight(7)\n with:"
       + "\n     board is " + new org.hamcrest.StringDescription().appendValue(this.board).toString();
    }catch(ArrayIndexOutOfBoundsException e){
      expectedException_1 = true;
    }
    Assert.assertTrue(message_1, expectedException_1);
  }
}
