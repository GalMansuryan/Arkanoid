// 211490297 Gal Mansuryan
package Shapes.GameItems;

import Game.Levels.GameLevel;
import Game.GameEnvironment;

import Listeners.HitListener;
import Movement.CollisionInfo;
import Movement.Sprite;
import Movement.Velocity;
import Shapes.Absract.Line;
import Shapes.Absract.Point;
import biuoop.DrawSurface;

import java.util.List;

/**
 * A class representing a ball in a game.
 */
public class Ball implements Sprite {
    private int size;
    private Point center;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment ge;
    private List<HitListener> hitListeners;

    /**
     * Constructs a new Ball object with the specified center point, radius, color,
     * game environment, and velocity.
     *
     * @param center           the center point of the ball
     * @param radius           the radius of the ball
     * @param color            the color of the ball
     * @param gameEnvironment  the game environment in which the ball operates
     * @param velocity         the velocity of the ball
     */
    public Ball(Point center, int radius, java.awt.Color color, GameEnvironment gameEnvironment, Velocity velocity) {
        this.velocity = velocity;
        this.ge = gameEnvironment;
        this.size = radius;
        this.center = center;

        this.color = color;
    }

    /**
     * Returns the x coordinate of the center point of the ball.
     *
     * @return the x coordinate of the center point
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Returns the y coordinate of the center point of the ball.
     *
     * @return the y coordinate of the center point
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Returns the size (radius) of the ball.
     *
     * @return the size of the ball
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns the color of the ball.
     *
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draws the ball on the given DrawSurface.
     *
     * @param surface the surface on which to draw the ball
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.size);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Sets the velocity of the ball to the given velocity.
     *
     * @param v the new velocity of the ball
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets the velocity of the ball to the given dx and dy values.
     *
     * @param dx the change in x coordinate per time unit
     * @param dy the change in y coordinate per time unit
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Returns the velocity of the ball.
     *
     * @return the velocity of the ball
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Moves the ball one step according to its current velocity, and handles collisions with the game frame.
     * If the ball collides with the game frame, flips its velocity in the appropriate direction.
     */
    public void moveOneStep() {
        Point endPoint = this.getVelocity().applyToPoint(this.center);
        Line trajectory = new Line(this.center, endPoint);
        if (this.ge.getClosestCollision(trajectory) != null) {
            CollisionInfo block = new CollisionInfo(this.ge.getClosestCollision(trajectory).collisionObject(),
                    trajectory);
            this.setVelocity(block.collisionObject().hit(this, this.ge.getClosestCollision(trajectory).collisionPoint(),
                    this.velocity));
        }
        endPoint = this.getVelocity().applyToPoint(this.center);
        trajectory = new Line(this.center, endPoint);
        if (this.ge.getClosestCollision(trajectory) != null) {
            CollisionInfo block = new CollisionInfo(this.ge.getClosestCollision(trajectory).collisionObject(),
                    trajectory);
            this.setVelocity(block.collisionObject().hit(this, this.ge.getClosestCollision(trajectory).collisionPoint(),
                    this.velocity));
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * Adds the ball to the game by adding it to the sprite collection of the game.
     *
     * @param g the game to add the ball to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * Removes the current sprite from the specified game.
     *
     * @param gameLevel The game from which the sprite will be removed.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}
