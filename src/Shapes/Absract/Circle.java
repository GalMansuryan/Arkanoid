// 211490297 Gal Mansuryan
package Shapes.Absract;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The Circle class represents a circle shape.
 */
public class Circle {
    private int radius;
    private Point center;
    private Color color;

    /**
     * Constructs a circle with the specified radius, center point, and color.
     *
     * @param radius the radius of the circle
     * @param center the center point of the circle
     * @param color  the color of the circle
     */
    public Circle(int radius, Point center, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    /**
     * Draws the circle on the specified DrawSurface.
     *
     * @param surface the DrawSurface to draw on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) center.getX(), (int) center.getY(), radius);
    }

    /**
     * Returns the color of the circle.
     *
     * @return the color of the circle
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the radius of the circle.
     *
     * @return the radius of the circle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Returns the center point of the circle.
     *
     * @return the center point of the circle
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Sets the center point of the circle.
     *
     * @param center the new center point of the circle
     */
    public void setCenter(Point center) {
        this.center = center;
    }
}
