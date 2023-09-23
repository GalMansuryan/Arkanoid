// 211490297 Gal Mansuryan
package Shapes.GameItems;

import Game.Levels.GameLevel;
import Listeners.HitListener;
import Listeners.HitNotifier;
import Movement.Collidable;
import Movement.Sprite;
import Movement.Velocity;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a block in a game.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private List<HitListener> hitListeners;

    public static final double EPSILON = 0.0001;

    /**
     * Constructs a new Shapes.GameItems.Block object with the given rectangle.
     *
     * @param rectangle the rectangle representing the block
     */
    public Block(Rectangle rectangle) {
        this.hitListeners = new ArrayList<>();
        this.rectangle = rectangle;

    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Returns true if the given two numbers are approximately equal (up to EPSILON), false otherwise.
     *
     * @param n1 the first number
     * @param n2 the second number
     * @return true if the given two numbers are approximately equal (up to EPSILON), false otherwise
     */
    public boolean equals(double n1, double n2) {
        return Math.abs(n1 - n2) < EPSILON;
    }

    /**
     * This method calculates the new velocity of a ball after hitting a block.
     *
     * @param collisionPoint  the point where the collision occurred
     * @param currentVelocity the current velocity of the ball
     * @return the new velocity after the collision
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // Check if collision point is null.
        if (collisionPoint == null) {
            return currentVelocity;
        }
        // If the collision is with the left or right edges of the block, flip the x velocity.
        if (equals(collisionPoint.getX(), this.rectangle.getUpperLeft().getX())
                || equals(collisionPoint.getX(), this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth())) {
            currentVelocity.flipDx();

        }
        // If the collision is with the top or bottom edges of the block, flip the y velocity.
        if (equals(collisionPoint.getY(), this.rectangle.getUpperLeft().getY())
                || equals(collisionPoint.getY(), this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight())) {
            currentVelocity.flipDy();

        }
        this.notifyHit(hitter);
        // Return the new velocity after the collision.
        return currentVelocity;
    }


    /**
     * This method draws the block on a given surface.
     *
     * @param d the surface on which the block will be drawn
     */
    @Override
    public void drawOn(DrawSurface d) {
        this.rectangle.drawOn(d);
    }

    @Override
    public void timePassed() {
    }

    /**
     * Adds the block to the game by adding it to the sprite and collidable collections of the game.
     *
     * @param g the game to add the block to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * Removes the current collidable and sprite from the specified game.
     *
     * @param gameLevel The game from which the collidable and sprite will be removed.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }
    /**
     * Notifies all registered hit listeners about a hit event with the specified ball.
     *
     * @param hitter The ball that caused the hit event.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
