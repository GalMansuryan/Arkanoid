// 211490297 Gal Mansuryan
package Movement;
import biuoop.DrawSurface;
/**
 * The Movment.Sprite interface should be implemented by any object that can be drawn to the screen and
 * that needs to be notified of time passed.
 */
public interface Sprite {
    /**
     * Draw the sprite on the given DrawSurface.
     * @param d the DrawSurface to draw on
     */
    void drawOn(DrawSurface d);
    /**
     * Notify the sprite that time has passed.
     */
    void timePassed();
}
