// 211490297 Gal Mansuryan
package Shapes.Absract;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Shapes.Absract.Rectangle class represents a 2D rectangle, defined by a Shapes.Absract.Point in the upper-left corner,
 * its width, height and color.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;
    private char type;

    /**
     * Create a new Shapes.Absract.Rectangle with the specified upper-left Shapes.Absract.Point, width,
     * height and color.
     *
     * @param upperLeft the upper-left Shapes.Absract.Point of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     * @param color     the color of the rectangle
     * @param type      the type of the rectangle ('f' for frame, 'b' for block)
     */
    public Rectangle(Point upperLeft, double width, double height, Color color, char type) {
        this.color = color;
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.type = type;
    }
    /**
     * Checks if a given point is inside the rectangle.
     *
     * @param p the point to check
     * @return true if the point is inside the rectangle, false otherwise
     */
    public Boolean isInside(Point p) {
        if (p.getX() >= this.getUpperLeft().getX() && p.getX() <= this.getUpperLeft().getX() + this.width) {
            return p.getY() >= this.getUpperLeft().getY() && p.getY() <= this.getUpperLeft().getY() + this.height;
        }
        return false;
    }

    /**
     * Returns a (possibly empty) List of intersection points between the rectangle and the specified line.
     *
     * @param line the line to check for intersections with the rectangle
     * @return a List of intersection points between the rectangle and the specified line
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new ArrayList<Point>();
        Point upperRight = new Point(width + this.upperLeft.getX(), this.upperLeft.getY());
        Point bottomLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point bottomRight = new Point(upperRight.getX(), bottomLeft.getY());

        Line topLine = new Line(this.upperLeft, upperRight);
        Line bottomLine = new Line(bottomLeft, bottomRight);
        Line leftLine = new Line(this.upperLeft, bottomLeft);
        Line rightLine = new Line(upperRight, bottomRight);

        if (line.intersectionWith(topLine) != null) {
            intersections.add(line.intersectionWith(topLine));
        }
        if (line.intersectionWith(bottomLine) != null) {
            intersections.add(line.intersectionWith(bottomLine));
        }
        if (line.intersectionWith(leftLine) != null) {
            intersections.add(line.intersectionWith(leftLine));
        }
        if (line.intersectionWith(rightLine) != null) {
            intersections.add(line.intersectionWith(rightLine));
        }
        if (intersections.isEmpty() && (isInside(line.end()) || isInside(line.start()))) {
            intersections.add(line.start());
        }
        return intersections;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left Shapes.Absract.Point of the rectangle.
     *
     * @return the upper-left Shapes.Absract.Point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Draws the rectangle on the specified DrawSurface.
     *
     * @param d the DrawSurface on which to draw the rectangle
     */
    public void drawOn(DrawSurface d) {
        if (type == 'f') {
            d.setColor(this.color);
            d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                    (int) this.width, (int) this.height);
        } else {
            d.setColor(this.color);
            d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                    (int) this.width, (int) this.height);
            d.setColor(Color.black);
            d.drawRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                    (int) this.width, (int) this.height);
        }

    }

}
