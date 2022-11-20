import java.awt.geom.Point2D;

public class Circle {
    private Point2D.Double middlePoint;
    private double radius;

    public Circle(Point2D.Double middlePoint, double radius) {
        setMiddlePoint(middlePoint);
        setRadius(radius);
    }

    private void setMiddlePoint(Point2D.Double middlePoint) {
        if (middlePoint == null) throw new IllegalArgumentException("middlePoint cannot be null");
        if (middlePoint.x < 0 || middlePoint.y < 0) throw new IllegalArgumentException("Coordinates cannot be negative");
        this.middlePoint = middlePoint;
    }

    private void setRadius(double straal) {
        if (straal < 0) throw new IllegalArgumentException("Straal moet positief zijn!");
        if (straal > middlePoint.x || straal > middlePoint.y) throw new IllegalArgumentException("Straal mag niet groter zijn dan elk van de coördinaten van het middelpunt!");
        this.radius = straal;
    }

    public Point2D.Double getMiddlePoint() {
        return middlePoint;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    /** Find the distance between the center of the circle and the points given.
        If the distance between them is less than the radius then the point is inside the circle.
        If it is equal to the radius then the point is on the circumference of the circle.
        If it is greater than the radius then the point is outside the circle.
     */
    public boolean isInside(Point2D.Double punt) {
        if (punt == null) throw new IllegalArgumentException("Point cannot be null");
        return Math.sqrt(Math.pow(middlePoint.x - punt.x, 2) + Math.pow(middlePoint.y - punt.y, 2)) <= radius;
    }

    public void increaseRadius(double factor) {
        if (factor <= 0) throw new IllegalArgumentException("Factor must be greater than 0!");
        setRadius(radius * factor);
    }
}
