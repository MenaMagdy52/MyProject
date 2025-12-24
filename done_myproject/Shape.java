
package myproject;

import java.util.Date;


public abstract class Shape implements Drawable{
      private Date dateCreated ;
      private String color ;

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getColor() {
        return color;
    }
      
      
    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
        
}
