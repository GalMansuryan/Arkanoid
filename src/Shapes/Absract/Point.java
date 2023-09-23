// 211490297 Gal Mansuryan
package Shapes.Absract;

/**
 * The Shapes.Absract.Point class represents a point in two-dimensional space with (x, y) coordinates.
 */
public class Point {
    //A small constant used to compare double values for equality.
    public static final double EPSILON = 0.0001;
    //The x-coordinate of this point.
    private double x;
    //The y-coordinate of this point.
    private double y;

    /**
     * Constructs a new Shapes.Absract.Point object with the specified (x, y) coordinates.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Constructs a new point with the same (x,y) coordinates as the given point.
     * @param p the point to duplicate
     */
    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * Calculates the distance between this point and another point.
     *
     * @param other the other point to calculate the distance to
     * @return the distance between this point and the other point
     */
    public double distance(Point other) {
        double distance;
        distance = (other.getX() - this.x) * (other.getX() - this.x);
        distance += (other.getY() - this.y) * (other.getY() - this.y);
        return Math.sqrt(distance);
    }

    /**
     * Compares this point with another point for equality.
     *
     * @param other the point to compare with this point
     * @return true if the object is a point and has the same (x, y) coordinates as this point, false otherwise
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return Math.abs(this.x - other.getX()) < EPSILON
                && Math.abs(this.y - other.getY()) < EPSILON;
    }

    /**
     * Returns the x-coordinate of this point.
     *
     * @return the x-coordinate of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Returns the y-coordinate of this point.
     *
     * @return the y-coordinate of this point
     */
    public double getY() {
        return this.y;
    }
    /**
     * Sets the x coordinate of this point to the given value.
     * @param x the new x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Sets the y coordinate of this point to the given value.
     * @param y the new y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }
}
