// 211490297 Gal Mansuryan
package Movement;

import Shapes.Absract.Point;

/**
 * Movment.Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor to create a new Movment.Velocity object with the given x and y components.
     *
     * @param dx The change in position on the x-axis.
     * @param dy The change in position on the y-axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Creates a Movment.Velocity object from a given angle and speed.
     *
     * @param angle The angle in degrees.
     * @param speed The speed of the object.
     * @return A new Movment.Velocity object.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * Gets the change in position on the x-axis.
     *
     * @return The change in position on the x-axis.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Gets the change in position on the y-axis.
     *
     * @return The change in position on the y-axis.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Flips the change in position on the x-axis.
     */
    public void flipDx() {
        this.dx = -this.dx;
    }

    /**
     * Flips the change in position on the y-axis.
     */
    public void flipDy() {
        this.dy = -this.dy;
    }

    /**
     * Takes a point with position (x, y) and returns a new point
     * with position (x + dx, y + dy) after applying the velocity.
     *
     * @param p The initial point to which the velocity will be applied.
     * @return A new Shapes.Absract.Point object with the updated position.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * Sets the velocity of the ball according to the given velocity.
     * @param v the velocity to set for the ball
     */
    public void setVelocity(Velocity v) {
        this.dx = v.getDx();
        this.dy = v.getDy();
    }

}