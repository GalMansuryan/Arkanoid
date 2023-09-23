// 211490297 Gal Mansuryan
package Score;

import Game.Counter;
import Listeners.HitListener;
import Shapes.GameItems.Ball;
import Shapes.GameItems.Block;

/**
 * The Score.ScoreTrackingListener class implements the Listeners.HitListener interface
 * and is responsible for tracking and updating the game score based on hit events.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * Constructs a Score.ScoreTrackingListener object with the specified score counter.
     *
     * @param scoreCounter The counter representing the current score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * Increases the score by 100. This method is typically called when the game is finished.
     */
    public void finishedGame() {
        currentScore.increase(100);
    }
    /**
     * Returns the current score counter.
     *
     * @return The current score counter.
     */
    public Counter getScore() {
        return currentScore;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}