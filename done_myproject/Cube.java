 
package myproject;

 
public class Cube extends ThreeDShape {
    private double side;

    public Cube(double s) {
        this.side = s;
    }
    public Cube(String c,double s) {
        super(c);
        this.side = s;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double s) {
        this.side = s;
    }

    @Override
    public String toString() {
        return "Cube{" + "side=" + side + '}';
    }

    @Override
    public double getVolume() {
            return side*side*side;
     }

    @Override
    public double getArea() {
        return 6*side*side;
    }

    @Override
    public double getPerimeter() {
            return 12.0*side;
    }

    @Override
    public String howToDraw() {
        return "Cube";
    }
    
}
