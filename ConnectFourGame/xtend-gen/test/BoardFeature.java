package test;

import org.jnario.runner.Contains;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import test.BoardFeatureBoardColumnHeightCheckBlankBoard;
import test.BoardFeatureBoardColumnHeightCheckNotEmptyColumns;
import test.BoardFeatureBoardNeedsToBeCleared;
import test.BoardFeaturePlayerAttemptsToPlayOutOfBounds;
import test.BoardFeaturePlayingAPiece;

@Contains({ BoardFeaturePlayingAPiece.class, BoardFeaturePlayerAttemptsToPlayOutOfBounds.class, BoardFeatureBoardColumnHeightCheckBlankBoard.class, BoardFeatureBoardColumnHeightCheckNotEmptyColumns.class, BoardFeatureBoardNeedsToBeCleared.class })
@Named("Board")
@RunWith(FeatureRunner.class)
@SuppressWarnings("all")
public class BoardFeature {
}
