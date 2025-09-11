package ca.nait.dmit2015;

public class Circle {

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Create a circle with a radius of 1
    public Circle() {
        setRadius(1);
    }

    // Create a circle with a specific radius
    public Circle(double radius) {
        setRadius(radius);
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public double perimeter() {
        return 2 * radius * Math.PI;
    }

    public double diameter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return String.format(
                "Radius: %s, Area: %.2f, Diameter: %s, Perimeter: %.3f",
                radius,
                area(),
                diameter(),
                perimeter()
        );
    }

}
