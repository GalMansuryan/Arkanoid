// 211490297 Gal Mansuryan
package Removers;

import Game.Counter;
import Game.Levels.GameLevel;
import Listeners.HitListener;
import Shapes.GameItems.Ball;
import Shapes.GameItems.Block;

/**
 * The Removers.BallRemover class implements the Listeners.HitListener interface
 * and is responsible for removing balls from the game when they hit a block.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;
    /**
     * Constructs a Removers.BallRemover object with the specified game and ball counter.
     *
     * @param gameLevel   The game from which the balls will be removed.
     * @param balls  The counter representing the remaining balls in the game.
     */
    public BallRemover(GameLevel gameLevel, Counter balls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = balls;

    }
    /**
     * Returns the number of remaining balls.
     *
     * @return The number of remaining balls.
     */
    public int getRemainingBalls() {
        return this.remainingBalls.getValue();
    }

    /**
     * Handles the hit event when a block is hit by a ball.
     * Removes the ball from the game and decreases the remaining ball count.
     *
     * @param beingHit The block being hit.
     * @param hitter   The ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        remainingBalls.decrease(1);
    }
}
