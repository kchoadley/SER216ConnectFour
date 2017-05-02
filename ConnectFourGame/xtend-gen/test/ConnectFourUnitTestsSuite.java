package test;

import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import test.BoardFeature;
import test.ComputerPlayerFeature;
import test.GameFeature;

@Named("ConnectFourUnitTests")
@Contains({ BoardFeature.class, ComputerPlayerFeature.class, GameFeature.class })
@RunWith(ExampleGroupRunner.class)
@SuppressWarnings("all")
public class ConnectFourUnitTestsSuite {
}
