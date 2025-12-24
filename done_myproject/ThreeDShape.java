
package myproject;


public abstract class ThreeDShape extends Shape {
    public abstract double getVolume();

    public ThreeDShape(String color) {
        super(color);
    }

    public ThreeDShape() {
    }
            
}
