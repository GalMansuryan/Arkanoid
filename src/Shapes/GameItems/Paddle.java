// 211490297 Gal Mansuryan
package Shapes.GameItems;

import Game.Levels.GameLevel;
import Movement.Collidable;
import Movement.Sprite;
import Movement.Velocity;
import Shapes.Absract.Point;
import Shapes.Absract.Rectangle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * The Shapes.GameItems.Paddle class is responsible for defining and managing the paddle object in the game.
 */
public class Paddle implements Sprite, Collidable {
    public static final double EPSILON = 0.0001;
    private final biuoop.KeyboardSensor keyboard;
    private final Rectangle paddle;
    private final Block rightEdge;
    private final Block leftEdge;
    private final int speed;

    /**
     * Constructs a new Paddle object with the specified rectangle shape, GUI for keyboard input,
     * right edge block, left edge block, and speed.
     *
     * @param rec   the rectangle shape of the paddle
     * @param gui         the GUI for keyboard input
     * @param rightEdge   the right edge block
     * @param leftEdge    the left edge block
     * @param speed       the speed of the paddle
     */
    public Paddle(Rectangle rec, GUI gui, Block rightEdge, Block leftEdge, int speed) {
        this.keyboard = gui.getKeyboardSensor();
        this.paddle = rec;
        this.rightEdge = rightEdge;
        this.leftEdge = leftEdge;
        this.speed = speed;
    }

    /**
     * Moves the paddle to the left by 5 units if not passing the edge.
     */
    public void moveLeft() {
        if (this.paddle.getUpperLeft().getX() - speed >= this.leftEdge.getCollisionRectangle().getUpperLeft().getX()
                + leftEdge.getCollisionRectangle().getWidth()) {
            this.paddle.getUpperLeft().setX(paddle.getUpperLeft().getX() - speed);
        } else {
            this.paddle.getUpperLeft().setX(this.leftEdge.getCollisionRectangle().getUpperLeft().getX()
                    + leftEdge.getCollisionRectangle().getWidth());
        }

    }

    /**
     * Moves the paddle to the right by 5 units if not passing the edge.
     */
    public void moveRight() {
        if (this.paddle.getUpperLeft().getX() + this.paddle.getWidth() + speed
                <= this.rightEdge.getCollisionRectangle().getUpperLeft().getX()) {
            this.paddle.getUpperLeft().setX(paddle.getUpperLeft().getX() + speed);
        } else {
            this.paddle.getUpperLeft().setX(this.rightEdge.getCollisionRectangle().getUpperLeft().getX()
                    - this.paddle.getWidth());
        }
    }

    /**
     * Draws the paddle on the given DrawSurface.
     *
     * @param d the DrawSurface object to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        this.paddle.drawOn(d);
    }

    /**
     * Moves the paddle left or right based on the keyboard input.
     */
    public void timePassed() {
        if (this.keyboard.isPressed("a") || this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else if (this.keyboard.isPressed("d") || this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * Returns the Shapes.Absract.Rectangle object representing the paddle.
     *
     * @return the Shapes.Absract.Rectangle object representing the paddle
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * Checks if two numbers are equal within a certain range of error.
     *
     * @param n1 the first number
     * @param n2 the second number
     * @return true if the numbers are equal within the range of error, false otherwise
     */
    public boolean equals(double n1, double n2) {
        return Math.abs(n1 - n2) < EPSILON;
    }

    /**
     * Determines the hit region of the paddle based on the collision point.
     *
     * @param collisionPoint the collision point of the ball
     * @return the hit region of the paddle (1-5)
     */
    public int getHitRegion(Point collisionPoint) {
        double x = collisionPoint.getX();
        double fifth = this.paddle.getWidth() / 5;
        if (x >= this.paddle.getUpperLeft().getX() && x <= this.paddle.getUpperLeft().getX() + fifth) {
            return 1;
        } else if (x > this.paddle.getUpperLeft().getX() + fifth && x
                <= this.paddle.getUpperLeft().getX() + 2 * fifth) {
            return 2;
        } else if (x > this.paddle.getUpperLeft().getX() + 2 * fifth && x
                <= this.paddle.getUpperLeft().getX() + 3 * fifth) {
            return 3;
        } else if (x > this.paddle.getUpperLeft().getX() + 3 * fifth && x
                <= this.paddle.getUpperLeft().getX() + 4 * fifth) {
            return 4;
        } else {
            return 5;
        }
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // If the collision point is on the left or right edge of the paddle, reverse the horizontal velocity.
        if (equals(collisionPoint.getY(), this.paddle.getUpperLeft().getY()) || equals(collisionPoint.getY(),
                this.paddle.getUpperLeft().getY() + this.paddle.getHeight())) {
            // If the collision point is on the top or bottom edge of the paddle, change the angle and speed of the
            // velocity accordingly.
            int region = getHitRegion(collisionPoint);
            // Calculate the speed of the current velocity.
            double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
            if (region == 3) {
                currentVelocity.flipDy();
            } else if (region == 1) {
                currentVelocity.setVelocity(Velocity.fromAngleAndSpeed(300, speed));
            } else if (region == 5) {
                currentVelocity.setVelocity(Velocity.fromAngleAndSpeed(60, speed));
            } else if (region == 2) {
                currentVelocity.setVelocity(Velocity.fromAngleAndSpeed(330, speed));
            } else {
                currentVelocity.setVelocity(Velocity.fromAngleAndSpeed(30, speed));
            }
        } else if (equals(collisionPoint.getX(), this.paddle.getUpperLeft().getX()) || equals(collisionPoint.getX(),
                this.paddle.getUpperLeft().getX() + this.paddle.getWidth())) {
            currentVelocity.flipDx();
        }
        // Return the new velocity after the collision.
        return currentVelocity;
    }

    /**
     * Adds this paddle to the given game.
     *
     * @param g the game to add the paddle to
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}