// 211490297 Gal Mansuryan
package Game;

import Movement.Collidable;
import Movement.CollisionInfo;
import Shapes.Absract.Line;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing the game environment, which includes all the collidable objects in the game.
 */
public class GameEnvironment {
    private List<Collidable> collidableList = new ArrayList<>();

    /**
     * Adds the given collidable object to the environment.
     *
     * @param c the collidable object to add
     */
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }
    /**
     * Removes the specified collidable from the collidable list.
     *
     * @param c The collidable to be removed.
     */
    public void removeCollidable(Collidable c) {
        this.collidableList.remove(c);
    }

    /**
     * Checks if a given trajectory line collides with any collidable objects in the environment.
     * If it does, returns the closest collision point and the collidable object involved.
     *
     * @param trajectory the line representing the trajectory of an object
     * @return a Movment.CollisionInfo object representing the closest collision, or null if no collision occurs
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        if (this.collidableList.isEmpty()) {
            return null;
        }
        // Initialize variables to store information about the closest collision
        boolean isCollisionExist = false;
        CollisionInfo closestInfo = null;
        Point closestCollision = null;
        Point currentCollision;
        List<Collidable> collidables = new ArrayList<>(this.collidableList);
        // Iterate over the collidables in the list
        for (int i = 0; i < collidables.size(); i++) {
            Rectangle object = collidables.get(i).getCollisionRectangle();
            if (!object.intersectionPoints(trajectory).isEmpty() && !isCollisionExist) {
                // Found the first collision
                isCollisionExist = true;
                closestInfo = new CollisionInfo(collidables.get(i), trajectory);
                closestCollision = closestInfo.collisionPoint();
            } else if (!object.intersectionPoints(trajectory).isEmpty()) {
                // Found another collision, check if it's closer than the previous one
                CollisionInfo currentInfo = new CollisionInfo(collidables.get(i), trajectory);
                currentCollision = currentInfo.collisionPoint();
                assert closestCollision != null;
                if (trajectory.start().distance(closestCollision) > trajectory.start().distance(currentCollision)) {
                    closestCollision = currentCollision;
                    closestInfo = currentInfo;
                }
            }

        }
        return closestInfo;
    }

}
