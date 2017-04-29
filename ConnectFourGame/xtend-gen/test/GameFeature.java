package test;

import org.jnario.runner.Contains;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import test.GameFeaturePlayerScoreRequired;
import test.GameFeatureWinnerDetectionWinningColumnPresent;
import test.GameFeatureWinnerDetectionWinningDiagonalPresentDownToRight;
import test.GameFeatureWinnerDetectionWinningDiagonalPresentUpToRight;
import test.GameFeatureWinnerDetectionWinningRowPresent;

@Contains({ GameFeaturePlayerScoreRequired.class, GameFeatureWinnerDetectionWinningColumnPresent.class, GameFeatureWinnerDetectionWinningRowPresent.class, GameFeatureWinnerDetectionWinningDiagonalPresentUpToRight.class, GameFeatureWinnerDetectionWinningDiagonalPresentDownToRight.class })
@Named("Game")
@RunWith(FeatureRunner.class)
@SuppressWarnings("all")
public class GameFeature {
}
