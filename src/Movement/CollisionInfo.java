// 211490297 Gal Mansuryan
package Movement;

import Shapes.Absract.Line;
import Shapes.Absract.Point;

/**
 * A class representing information about a collision.
 */
public class CollisionInfo {
    private Collidable collisionObject;
    private Line trajectory;
    /**
     * Constructs a new Movment.CollisionInfo object with the given collidable object and trajectory.
     *
     * @param object     the collidable object involved in the collision
     * @param trajectory the trajectory of the object when the collision occurs
     */
    public CollisionInfo(Collidable object, Line trajectory) {
        this.collisionObject = object;
        this.trajectory = trajectory;
    }


    /**
     * Returns the point at which the collision occurs.
     *
     * @return the point at which the collision occurs
     */
    public Point collisionPoint() {
        return this.trajectory.closestIntersectionToStartOfLine(this.collisionObject.getCollisionRectangle());
    }

    /**
     * Returns the collidable object involved in the collision.
     *
     * @return the collidable object involved in the collision
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
