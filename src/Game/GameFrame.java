// 211490297 Gal Mansuryan
package Game;

import Shapes.Absract.Point;

/**
 * The Game.GameFrame class represents a rectangular game frame in a two-dimensional game world.
 * A game frame is defined by a starting point and an end point, or alternatively by a width and a height.
 */
public class GameFrame {
    // The starting point of the game frame default value.
    private static final Point START_POINT = new Point(0, 0);
    // The width and height of the game frame.
    private double width;
    private double height;
    // The starting and end points of the game frame.
    private Point startPoint = START_POINT;
    private Point endPoint;

    /**
     * Constructs a new Game.GameFrame object with the specified width and height.
     *
     * @param width  the width of the game frame
     * @param height the height of the game frame
     */
    public GameFrame(double width, double height) {
        this.width = width;
        this.height = height;
        this.endPoint = new Point(width, height);
    }

    /**
     * Constructs a new Game.GameFrame object with the specified starting and end points.
     *
     * @param start the starting point of the game frame
     * @param end   the end point of the game frame
     */
    public GameFrame(Point start, Point end) {
        this.startPoint = start;
        this.width = end.getX() - start.getX();
        this.height = end.getY() - start.getY();
        this.endPoint = end;
    }

    /**
     * Returns the width of the game frame.
     *
     * @return the width of the game frame
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the game frame.
     *
     * @return the height of the game frame
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the starting point of the game frame.
     *
     * @return the starting point of the game frame
     */
    public Point getStartPoint() {
        return this.startPoint;
    }

    /**
     * Returns the end point of the game frame.
     *
     * @return the end point of the game frame
     */
    public Point getEndPoint() {
        return this.endPoint;
    }

    /**
     * Checks if a given x coordinate with a specified radius is overlapping with the left edge of the game frame.
     *
     * @param x      the x coordinate to check
     * @param radius the radius of the object to check
     * @return true if the object is overlapping with the left edge of the game frame, false otherwise
     */
    public boolean isOverlappingLeft(double x, double radius) {
        return (x - radius) <= this.startPoint.getX();
    }

    /**
     * Checks if a given x coordinate with a specified radius is overlapping with the right edge of the game frame.
     *
     * @param x      the x coordinate to check
     * @param radius the radius of the object to check
     * @return true if the object is overlapping with the right edge of the game frame, false otherwise
     */
    public boolean isOverlappingRight(double x, double radius) {
        return (x + radius) >= (this.width + this.startPoint.getX());
    }

    /**
     * Checks if a given x coordinate with a specified radius is overlapping with either X edge of the game frame.
     *
     * @param x      the x coordinate to check
     * @param radius the radius of the object to check
     * @return true if the object is overlapping with either X edge of the game frame, false otherwise
     */
    public boolean isOverlappingX(double x, double radius) {
        return isOverlappingLeft(x, radius) || isOverlappingRight(x, radius);
    }

    /**
     * Checks if a given y coordinate with a specified radius is overlapping with the top edge of the game frame.
     *
     * @param y      the y coordinate to check
     * @param radius the radius of the object to check
     * @return true if the object is overlapping with the top edge of the game frame, false otherwise
     */
    public boolean isOverlappingTop(double y, double radius) {
        return (y + radius) >= (this.height + this.startPoint.getY());
    }

    /**
     * Checks if a given y coordinate with a specified radius is overlapping with the bottom edge of the game frame.
     *
     * @param y      the y coordinate to check
     * @param radius the radius of the object to check
     * @return true if the object is overlapping with the bottom edge of the game frame, false otherwise
     */
    public boolean isOverlappingBottom(double y, double radius) {
        return (y - radius) <= this.startPoint.getY();
    }

    /**
     * Checks if a given y coordinate with a specified radius is overlapping with either Y edge of the game frame.
     *
     * @param y      the y coordinate to check
     * @param radius the radius of the object to check
     * @return true if the object is overlapping with either Y edge of the game frame, false otherwise
     */
    public boolean isOverlappingY(double y, double radius) {
        return isOverlappingTop(y, radius) || isOverlappingBottom(y, radius);
    }

}
