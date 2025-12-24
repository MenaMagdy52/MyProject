package myproject;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawShapes extends JPanel {

    private Drawable[] shapesToDraw;

    public DrawShapes(Drawable[] shapes) {
        this.shapesToDraw = shapes;
        this.setBackground(Color.BLACK); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 50;  
        int y = 100; 

        g.setColor(Color.RED);  //  (Default Color)


        for (Drawable d : shapesToDraw) {
            if (d == null) continue;

   
            if (d instanceof Circle) {
                g.setColor(Color.ORANGE); 
                
                Circle c = (Circle) d;
                int diameter = (int) (c.getRadius() * 2);
                
                g.fillOval(x, y, diameter, diameter);
                g.drawString("Circle", x, y + diameter + 20);
                
                x += diameter + 50; 
            } 
            
         
            else if (d instanceof Cube) {
                g.setColor(Color.GREEN); 
                
                Cube cb = (Cube) d;
                int side = (int) cb.getSide();
                int shift = side / 3; 

                // 1. الوجه الخلفي
                g.drawRect(x + shift, y - shift, side, side);

                // 2. الوجه الأمامي
                g.drawRect(x, y, side, side);

                // 3. توصيل الزوايا (Wireframe)
                g.drawLine(x, y, x + shift, y - shift); 
                g.drawLine(x + side, y, x + side + shift, y - shift); 
                g.drawLine(x, y + side, x + shift, y + side - shift); 
                g.drawLine(x + side, y + side, x + side + shift, y + side - shift); 

                g.drawString("Cube 3D", x, y + side + 20);
                
                x += side + shift + 50;
            }
        }
    }
}