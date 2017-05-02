package test;

import org.jnario.runner.Contains;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import test.ComputerPlayerFeatureComputerMakesAPlayOnABlankBoard;
import test.ComputerPlayerFeatureComputerMakesAPlayOnANonBlankBoard;

@Contains({ ComputerPlayerFeatureComputerMakesAPlayOnABlankBoard.class, ComputerPlayerFeatureComputerMakesAPlayOnANonBlankBoard.class })
@Named("Computer Player")
@RunWith(FeatureRunner.class)
@SuppressWarnings("all")
public class ComputerPlayerFeature {
}
