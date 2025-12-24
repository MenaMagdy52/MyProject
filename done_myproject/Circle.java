
package myproject;

public class Circle extends Shape{
    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    public Circle( String c,double r) {
        super(c);
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius ;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String howToDraw() {
return "Circle ";
    }
    
    
}
