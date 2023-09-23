// 211490297 Gal Mansuryan
package Movement;

import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import Shapes.GameItems.Ball;

/**
 * An interface representing a collidable object in the game.
 */
public interface Collidable {
    /**
     * Returns the "collision shape" of the object.
     *
     * @return the rectangle representing the collision shape
     */
    Rectangle getCollisionRectangle();

    /**
     * Notifies the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param hitter          The ball that collided with the object.
     * @param collisionPoint  the point where the collision occurred
     * @param currentVelocity the current velocity of the object
     * @return the new velocity expected after the hit
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
