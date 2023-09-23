// 211490297 Gal Mansuryan
package Removers;

import Game.Counter;
import Game.Levels.GameLevel;
import Listeners.HitListener;
import Shapes.GameItems.Ball;
import Shapes.GameItems.Block;

/**
 * The Removers.BlockRemover class implements the Listeners.HitListener interface
 * and is responsible for removing blocks from the game when they are hit.
 * It also keeps track of the remaining number of blocks.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    /**
     * Constructs a Removers.BlockRemover object with the specified game and counter for removed blocks.
     *
     * @param gameLevel           The game from which the blocks will be removed.
     * @param removedBlocks  The counter representing the remaining blocks in the game.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;

    }
    /**
     * Returns the number of remaining blocks.
     *
     * @return The number of remaining blocks.
     */
    public int getRemainingBlocks() {
        return this.remainingBlocks.getValue();
    }

    /**
     * Handles the hit event when a block is hit by a ball.
     * Removes the block from the game, removes this listener from the block, and decreases the remaining block count.
     *
     * @param beingHit The block being hit.
     * @param hitter   The ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(gameLevel);
        remainingBlocks.decrease(1);
    }
}