// 211490297 Gal Mansuryan
package Animation;

import biuoop.DrawSurface;
/**
 * The Animation interface represents an animation that can be displayed on a DrawSurface.
 */
public interface Animation {
    /**
     * Performs one frame of the animation on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    void doOneFrame(DrawSurface d);

    /**
     * Determines whether the animation should stop or continue.
     *
     * @return true if the animation should stop, false otherwise
     */
    boolean shouldStop();
}
