// 211490297 gal mansuryan
package Shapes.Absract;

import java.util.List;

/**
 * The Shapes.Absract.Line class represents a line segment in two-dimensional space.
 * The line segment is defined by its starting and ending points.
 */
public class Line {
    //A small constant used to compare double values for equality.
    public static final double EPSILON = 0.0001;
    //The starting point of this line segment.
    private Point start;
    //The ending point of this line segment.
    private Point end;

    /**
     * Constructs a new Shapes.Absract.Line object with the given starting and ending points.
     *
     * @param start the starting point of the line segment
     * @param end   the ending point of the line segment
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;

    }

    /**
     * Constructs a new Shapes.Absract.Line object with the given coordinates for the starting and ending points.
     *
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Returns the length of this line segment.
     *
     * @return the length of this line segment
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Returns the middle point of this line segment.
     *
     * @return the middle point of this line segment
     */
    public Point middle() {
        double xM = (this.start.getX() + this.end.getX()) / 2;
        double yM = (this.start.getY() + this.end.getY()) / 2;
        return new Point(xM, yM);
    }

    /**
     * Returns the starting point of this line segment.
     *
     * @return the starting point of this line segment
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the ending point of this line segment.
     *
     * @return the ending point of this line segment
     */
    public Point end() {
        return this.end;
    }

    /**
     * Compares this line segment to the given line segment for equality.
     *
     * @param other the line segment to compare to
     * @return true if the line segments are equal, false otherwise
     */
    public boolean equals(Line other) {
        return other.start.getX() == this.start.getX()
                && other.start.getY() == this.start.getY()
                && other.end.getX() == this.end.getX()
                && other.end.getY() == this.end.getY();
    }

    /**
     * Compares two double values for equality using the EPSILON constant.
     *
     * @param n1 the first double value
     * @param n2 the second double value
     * @return true if the double values are equal, false otherwise
     */
    public boolean isDoublesEqual(double n1, double n2) {
        return Math.abs(n1 - n2) < EPSILON;
    }

    /**
     * Returns true if this line segment is vertical, false otherwise.
     *
     * @return true if this line segment is vertical, false otherwise
     */
    public boolean isVertical() {
        return isDoublesEqual(this.start.getX(), this.end.getX());
    }

    /**
     * Returns true if this line segment is horizontal, false otherwise.
     *
     * @return true if this line segment is horizontal, false otherwise
     */
    public boolean isHorizontal() {
        return isDoublesEqual(this.start.getY(), this.end.getY());
    }

    /**
     * Returns the incline of this line segment. If the line segment is vertical, returns Double.POSITIVE_INFINITY.
     *
     * @return the incline of this line segment, or Double.POSITIVE_INFINITY if the line segment is vertical
     */
    public double getIncline() {
        if (isVertical()) {
            return Double.POSITIVE_INFINITY;
        }
        double result = this.start.getY() - this.end.getY();
        result /= (this.start.getX() - this.end.getX());
        return result;
    }

    /**
     * Returns the y-intercept of this line segment. If the line segment is vertical, returns 0.
     *
     * @return the y-intercept of this line segment, or 0 if the line segment is vertical
     */
    public double getYIntercept() {
        if (isVertical()) {
            return 0;
        }
        return this.start.getY() - (this.getIncline() * this.start.getX());
    }

    /**
     * Returns the x-coordinate of the point where this line segment intersects the given line segment.
     * If the line segments are parallel, returns Double.NaN.
     *
     * @param other the line segment to intersect with
     * @return the x-coordinate of the intersection point, or Double.NaN if the line segments are parallel
     */
    public double getCommonX(Line other) {
        if (isVertical()) {
            return this.start.getX();
        } else if (other.isVertical()) {
            return other.start.getX();
        } else {
            double result = other.getYIntercept() - this.getYIntercept();
            result /= (this.getIncline() - other.getIncline());
            return result;
        }
    }

    /**
     * Returns the y-coordinate of the point on this line segment for the given x-coordinate.
     *
     * @param x the x-coordinate of the point
     * @return the y-coordinate of the point on this line segment for the given x-coordinate
     */
    public double getYForSpecificX(double x) {
        return this.getIncline() * x + this.getYIntercept();
    }

    /**
     * Returns true if the given point is within the range of this line segment, false otherwise.
     *
     * @param p the point to check
     * @return true if the given point is within the range of this line segment, false otherwise
     */
    public boolean isInRange(Point p) {
        if (p == null) {
            return false;
        }
        return ((((isDoublesEqual(p.getX(), this.start.getX()) || p.getX() > this.start.getX())
                && (isDoublesEqual(p.getX(), this.end.getX()) || p.getX() < this.end.getX()))
                || ((isDoublesEqual(p.getX(), this.start.getX()) || p.getX() < this.start.getX())
                && (isDoublesEqual(p.getX(), this.end.getX()) || p.getX() > this.end.getX())))
                && (((isDoublesEqual(p.getY(), this.start.getY()) || p.getY() > this.start.getY())
                && (isDoublesEqual(p.getY(), this.end.getY()) || p.getY() < this.end.getY()))
                || ((isDoublesEqual(p.getY(), this.start.getY()) || p.getY() < this.start.getY())
                && (isDoublesEqual(p.getY(), this.end.getY()) || p.getY() > this.end.getY()))));
    }

    /**
     * Returns true if the given point is within the range of both this line segment and the given line segment.
     *
     * @param other the line segment to check against
     * @param point the point to check
     * @return true if the given point is within the range of both this line segment and the given line segment.
     */
    public boolean isPointInRangeOfBothLines(Line other, Point point) {
        return this.isInRange(point) && other.isInRange(point);
    }

    /**
     * Returns the point with the maximum x-coordinate among the given points.
     * If both points have the same x-coordinate, returns the point with the maximum y-coordinate.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the maximum point
     */
    public Point getMaxPoint(Point p1, Point p2) {
        if (p1.getX() > p2.getX()) {
            return p1;
        } else if (p1.getX() < p2.getX()) {
            return p2;
        } else {
            return p1.getY() > p2.getY() ? p1 : p2;
        }
    }

    /**
     * Returns the point with the minimum x-coordinate among the given points.
     * If both points have the same x-coordinate, returns the point with the minimum y-coordinate.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the minimum point
     */
    public Point getMinPoint(Point p1, Point p2) {
        if (p1.getX() > p2.getX()) {
            return p2;
        } else if (p1.getX() < p2.getX()) {
            return p1;
        } else {
            return p1.getY() > p2.getY() ? p2 : p1;
        }
    }

    /**
     * Returns the intersection point of two non-parallel lines with the given slopes, or null if they do not intersect.
     *
     * @param other      the other line
     * @param mySlope    the slope of this line
     * @param otherSlope the slope of the other line
     * @return the intersection point of two non-parallel lines with the given slopes, or null if they do not intersect
     */
    private Point intersectionWithNonParallelLines(Line other, double mySlope, double otherSlope) {
        double xInter;
        double yInter;

        if (Double.isInfinite(mySlope) || Double.isInfinite(otherSlope)) {
            Line verticalLine = Double.isInfinite(mySlope) ? this : other;
            Line nonVerticalLine = Double.isInfinite(mySlope) ? other : this;

            xInter = verticalLine.start.getX();
            yInter = nonVerticalLine.getIncline() * xInter + nonVerticalLine.getYIntercept();
        } else {
            xInter = (other.getYIntercept() - getYIntercept()) / (mySlope - otherSlope);
            yInter = xInter * mySlope + getYIntercept();
        }

        Point intersection = new Point(xInter, yInter);

        if (isInRange(intersection) && other.isInRange(intersection)) {
            return intersection;
        } else {
            return null;
        }
    }

    /**
     * Returns true if this line segment intersects the given line segment only in one edge, false otherwise.
     *
     * @param other the line segment to check against
     * @return true if this line segment intersects the given line segment only in one edge, false otherwise
     */
    public boolean isIntersectingInOneEdge(Line other) {
        return getMinPoint(this.start, this.end).equals(getMaxPoint(other.start, other.end))
                || getMaxPoint(this.start, this.end).equals(getMinPoint(other.start, other.end));
    }

    /**
     * Returns true if this line segment and the given line segment have more than one common point.
     *
     * @param other the line segment to check against
     * @return true if this line segment and the given line segment have more than one common point
     */
    public boolean isConverting(Line other) {
        return (isInRange(other.start) || isInRange(other.end)) && !isIntersectingInOneEdge(other);
    }

    /**
     * Returns true if this line segment collides with the given line segment at a vertical line, false otherwise.
     *
     * @param other the line segment to check against
     * @return true if this line segment collides with the given line segment at a vertical line, false otherwise
     */
    public boolean isCollidingVertical(Line other) {
        if (isDoublesEqual(this.start.getX(), other.start.getX())) {
            return isConverting(other);
        } else {
            return false;
        }
    }

    /**
     * Returns true if this line segment collides with the given line segment at a horizontal line, false otherwise.
     *
     * @param other the line segment to check against
     * @return true if this line segment collides with the given line segment at a horizontal line, false otherwise
     */
    public boolean isCollidingHorizontal(Line other) {
        if (isDoublesEqual(this.start.getY(), other.start.getY())) {
            return isConverting(other);
        } else {
            return false;
        }
    }

    /**
     * Returns true if this line segment collides with the given line segment, false otherwise.
     *
     * @param other the line segment to check against
     * @return true if this line segment collides with the given line segment, false otherwise
     */
    public boolean isCollidingRegular(Line other) {
        if (isDoublesEqual(other.getIncline(), getIncline())
                && isDoublesEqual(other.getYIntercept(), getYIntercept())) {
            return isConverting(other);
        } else {
            return false;
        }
    }

    /**
     * Checks if this line is colliding with another line.
     *
     * @param other the other line to check
     * @return true if there is a collision, false otherwise
     */
    public boolean isColliding(Line other) {
        return isCollidingRegular(other) || isCollidingHorizontal(other)
                || isCollidingVertical(other);
    }

    /**
     * Checks if there is an intersecting point between this line and another line.
     *
     * @param other the other line to check
     * @return true if an intersecting point exists, false otherwise
     */
    public boolean isIntersectingPointExist(Line other) {
        // If both lines share one of their edges, they intersect
        if (isIntersectingInOneEdge(other)) {
            return true;
        }

        double x = getCommonX(other);

        // If both lines are either vertical or horizontal and do not collide, they intersect
        if ((this.isVertical() || other.isVertical()) && !isColliding(other)) {
            return true;
        } else if (this.isHorizontal() && other.isHorizontal()) {
            return !isCollidingHorizontal(other) && isIntersectingInOneEdge(other);
        } else if ((this.isVertical() && other.isHorizontal()) || (this.isHorizontal() && other.isVertical())) {
            // If one line is vertical and the other is horizontal, they intersect
            return true;
        } else if (isColliding(other)) { // If the two lines collide but do not share an edge, they do not intersect
            return false;
        }

        double yCurrent = getYForSpecificX(x);
        double yOther = other.getYForSpecificX(x);

        // If the y value of the two lines at the common x value is the same, they intersect
        return isDoublesEqual(yCurrent, yOther);
    }

    /**
     * Gets the intersecting point between this line and another line.
     *
     * @param other the other line to check
     * @return the intersecting point if it exists, null otherwise
     */
    public Point getIntersectingPoint(Line other) {
        if (isIntersectingPointExist(other)) {
            if ((this.isVertical() && other.isVertical())
                    || (this.isHorizontal() && other.isHorizontal())) {
                // If both lines are either vertical or horizontal, the intersection point is on the edge
                if (isIntersectingInOneEdge(other)) {
                    if (getMinPoint(this.start, this.end).equals(getMaxPoint(other.start, other.end))) {
                        return getMinPoint(this.start, this.end);
                    } else {
                        return getMaxPoint(this.start, this.end);
                    }
                } else {
                    // If those lines aren't intersecting on one edge, they're not intersecting at all
                    return null;
                }
            } else if (this.isVertical() && other.isHorizontal()) {
                // If this line is vertical and the other is horizontal, the intersection point is at (x1, y2)
                return new Point(this.start.getX(), other.start.getY());
            } else if (this.isHorizontal() && other.isVertical()) {
                return new Point(other.start.getX(), this.start.getY());
            } else if (this.isVertical()) {
                // If this line is vertical, compute the intersection point using the other line's equation
                double x = getCommonX(other);
                return new Point(x, other.getYForSpecificX(x));
            } else if (isIntersectingInOneEdge(other)) {
                // If the lines intersect on one edge, return the common point
                if (getMinPoint(this.start, this.end).equals(getMaxPoint(other.start, other.end))) {
                    return getMinPoint(this.start, this.end);
                } else {
                    return getMaxPoint(this.start, this.end);
                }
            } else {
                double x = getCommonX(other);
                System.out.println(x);
                return new Point(x, getYForSpecificX(x));
            }
        } else {
            return null;
        }
    }

    /**
     * Returns true if this line segment intersects the given line segment, false otherwise.
     *
     * @param other the line segment to check against
     * @return true if this line segment intersects the given line segment, false otherwise
     */
    public boolean isIntersecting(Line other) {
        Point point;

        // Case 1: Both lines are vertical
        if (this.isVertical() && other.isVertical()) {
            if (isCollidingVertical(other)) {
                // If they are colliding in the same point, return true
                return true;
            } else {
                // Otherwise, check if there is an intersecting point
                return getIntersectingPoint(other) != null;
            }

            // Case 2: One line is vertical and the other is horizontal
        } else if ((this.isVertical() && other.isHorizontal())
                || (this.isHorizontal() && other.isVertical())) {
            // Get the intersecting point
            point = getIntersectingPoint(other);
            // Check if the point is in range of both lines
            return isPointInRangeOfBothLines(other, point);

            // Case 3: Both lines are horizontal
        } else if (this.isHorizontal() && other.isHorizontal()) {
            // If they are colliding in the same point, return true
            // Otherwise, check if there is an intersecting point
            return isCollidingHorizontal(other) || getIntersectingPoint(other) != null;

            // Case 4: Neither of the above cases apply, check if there is a common intersecting point
        } else if (isCollidingRegular(other)) {
            // If they are colliding in the same point, return true
            return true;
        } else {
            // If there is no common intersecting point, check if there is an intersecting point in one of the lines
            if (isIntersectingPointExist(other)) {
                // Get the intersecting point
                point = getIntersectingPoint(other);
                // Check if the point is in range of both lines
                return isPointInRangeOfBothLines(other, point);
            }
        }
        // If none of the above cases apply, return false
        return false;
    }

    /**
     * Returns the intersection point of this line segment with the given line segment,or null if they do not intersect.
     *
     * @param other the line segment to intersect with
     * @return the intersection point of this line segment with the given line segment, or null if they do not intersect
     */
    public Point intersectionWith(Line other) {
        if (Math.abs(getIncline() - other.getIncline()) > EPSILON) {
            return intersectionWithNonParallelLines(other, getIncline(), other.getIncline());
        }
        if (isIntersecting(other)) {
            if (isColliding(other)) {
                return null;
            } else {
                return getIntersectingPoint(other);
            }
        }
        return null;
    }

    /**
     * Finds the closest intersection point to the start of the line with the given rectangle, if any.
     * If there are no intersections, returns null.
     * @param rect the rectangle to check for intersection
     * @return the closest intersection point to the start of the line, or null if there are no intersections
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersections = rect.intersectionPoints(this);
        if (intersections.isEmpty()) {
            return null;
        }
        Point closest = intersections.get(0);
        for (Point intersection : intersections) {
            if (closest.distance(this.start) > intersection.distance(this.start)) {
                closest = intersection;
            }
        }
        return closest;
    }


}
