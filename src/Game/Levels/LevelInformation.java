// 211490297 Gal Mansuryan
package Game.Levels;

import Movement.Sprite;
import Movement.Velocity;
import Shapes.GameItems.Block;

import java.util.List;
/**
 * The LevelInformation interface represents the properties and behavior
 * of a specific level in the game.
 */
public interface LevelInformation {
    /**
     * Returns the number of balls in the level.
     *
     * @return the number of balls
     */
    int numberOfBalls();
    /**
     * Returns a list of the initial velocities of the balls in the level.
     * The size of the list should be equal to the number of balls.
     *
     * @return the initial ball velocities
     */
    List<Velocity> initialBallVelocities();
    /**
     * Returns the speed of the paddle in the level.
     *
     * @return the paddle speed
     */
    int paddleSpeed();
    /**
     * Returns the width of the paddle in the level.
     *
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * Returns the name of the level.
     *
     * @return the level name
     */
    String levelName();
    /**
     * Returns the background sprite of the level.
     *
     * @return the background sprite
     */
    Sprite getBackground();
    /**
     * Returns a list of the blocks in the level.
     *
     * @return the blocks
     */
    List<Block> blocks();
    /**
     * Returns the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the number of blocks to remove
     */
    int numberOfBlocksToRemove();
}
