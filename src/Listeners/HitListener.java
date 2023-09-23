// 211490297 Gal Mansuryan
package Listeners;

import Shapes.GameItems.Ball;
import Shapes.GameItems.Block;


/**
 * The Listeners.HitListener interface represents an object that listens for hit events between blocks and balls.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit by a ball.
     *
     * @param beingHit The block that was hit.
     * @param hitter   The ball that hit the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
