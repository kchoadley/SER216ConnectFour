package connect.four.gui;

import connect.four.gui.JnarioTestFeature;
import connect.four.player.ConsolePlayer;
import org.jnario.lib.Assert;
import org.jnario.lib.Should;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Named("Scenario: Naming the player")
@SuppressWarnings("all")
public class JnarioTestFeatureNamingThePlayer extends JnarioTestFeature {
  ConsolePlayer person;
  
  String result;
  
  @Test
  @Order(0)
  @Named("Given a new player")
  public void _givenANewPlayer() {
    ConsolePlayer _consolePlayer = new ConsolePlayer("");
    this.person = _consolePlayer;
  }
  
  @Test
  @Order(1)
  @Named("When I give it a name")
  public void _whenIGiveItAName() {
    this.person.setName("Kris");
    String _name = this.person.getName();
    this.result = _name;
  }
  
  @Test
  @Order(2)
  @Named("Then it should return the same name")
  public void _thenItShouldReturnTheSameName() {
    Assert.assertTrue("\nExpected result => \"Kris\" but"
     + "\n     result is " + new org.hamcrest.StringDescription().appendValue(this.result).toString() + "\n", Should.<String>operator_doubleArrow(this.result, "Kris"));
    
  }
}
