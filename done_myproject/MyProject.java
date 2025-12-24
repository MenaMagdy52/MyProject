package myproject;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import javax.swing.JFrame;

public class MyProject {

    public static void main(String[] args) {

        Scanner input = null;
        Drawable[] arr = null;
        try {
            File file = new File("input.txt");
            input = new Scanner(file);
            int n = input.nextInt();
            if (n <= 2) {
            System.out.println("Error: Number of shapes must be positive");
                    return; 
}
            arr = new Drawable[n];
            double totalAreas = 0;
            for (int i = 0; i < n; i++) {
                String type = input.next();
                double len = input.nextDouble();

                switch (type) {
                    case "circle":
                    case "Circle":
                        arr[i] = new Circle(len);
                        break;

                    case "cube":
                    case "Cube":
                        arr[i] = new Cube(len);
                        break;
                    default:
                        continue;
                }
                if (arr[i] != null) {
                    totalAreas += ((Shape) arr[i]).getArea();
                    
                }

            }
            FileWriter fw = null;
            PrintWriter pw = null;

            try {
                fw = new FileWriter("sumAreas.txt");
                pw = new PrintWriter(fw);
                pw.println("Total Areas = " + totalAreas);
                System.out.println("Total Areas = " + totalAreas);
            } catch (IOException e) {
                System.out.println("Error Occurred during file writing\n" + e.getMessage());
                return;
            } finally {
                if (input != null) {
                    input.close();
                }

                if (pw != null) {
                    pw.close();
                }
            }

        } catch (FileNotFoundException e) { 
            System.out.println(" Erorr: File not found " + e.getMessage());
            return;
        }    catch (InputMismatchException e){
                    System.out.println("Erorr: You must enter the number of Shapes first ");
                    return;
                    }
         catch (Exception e) {
            System.out.println("Unknown Error occurred: " + e.getMessage());
            return;
        }
        if (arr != null) {
            // 1. نعمل الشباك (JFrame) جاهز من الجافا
            javax.swing.JFrame frame = new javax.swing.JFrame("My Project GUI");

            // 2. نعمل اللوحة بتاعتنا ونبعتلها البيانات
            DrawShapes panel = new DrawShapes(arr);

            // 3. نحط اللوحة جوه الشباك
            frame.add(panel);

            // 4. نظبط إعدادات الشباك
            frame.setSize(800, 600); // المقاس
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE); // يقفل البرنامج لما تدوس X
            frame.setLocationRelativeTo(null); // يظهر في النص
            frame.setVisible(true); // يظهر
        }
    }
}
