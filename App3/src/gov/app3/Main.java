package gov.app3;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Shapes");
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Square mySquare = new Square();
        Triangle myTriangle = new Triangle();
        Circle myCircle = new Circle();
        Rectangle myRectangle = new Rectangle();

        AtomicReference<Double> areaSum = new AtomicReference<>((double) 0);
        ArrayList<Double> areas = new ArrayList<>();
        AtomicReference<Double> perimeterSum = new AtomicReference<>((double) 0);
        ArrayList<Double> perimeters = new ArrayList<>();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> {
            areaSum.set(0.0);
            perimeterSum.set(0.0);
            areas.clear();
            perimeters.clear();
            frame.getContentPane().repaint();
            System.out.println("Everything got reset");

        });

        JButton rectangleButton = new JButton("Draw Rectangle");
        rectangleButton.addActionListener(e -> {
            System.out.println("Please give the starting coordinates and width & height for the rectangle:");
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            int y = in.nextInt();
            int rectangleWidth = in.nextInt();
            int rectangleHeight = in.nextInt();
            Graphics g = frame.getGraphics();
            g.drawRect(x, y, rectangleWidth, rectangleHeight);
            int rectangleArea = myRectangle.area(rectangleWidth, rectangleHeight);
            areas.add((double)rectangleArea);
            int rectanglePerimeter = myRectangle.perimeter(rectangleWidth, rectangleHeight);
            perimeters.add((double)rectanglePerimeter);
        });

        JButton triangleButton = new JButton("Draw Triangle");
        triangleButton.addActionListener(e -> {
            System.out.println("Please give the starting coordinates and edge length for the triangle:");
            Scanner in = new Scanner(System.in);
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int triangleEdge = in.nextInt();
            Graphics g = frame.getGraphics();
            int[] x = {x1, (x1 + triangleEdge), (x1 + triangleEdge / 2)}; // 100, 200, 150
            int[] y = {y1, y1, y1 + triangleEdge}; // 100, 100, 200
            g.drawPolygon(x, y, 3); //triangle
            double triangleArea = myTriangle.area(triangleEdge);
            areas.add(triangleArea);
            double trianglePerimeter = myTriangle.perimeter(triangleEdge);
            perimeters.add(trianglePerimeter);
        });

        JButton circleButton = new JButton("Draw Circle");
        circleButton.addActionListener(e -> {
            System.out.println("Please give the starting coordinates and radius values for the circle:");
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            int y = in.nextInt();
            int circleRadius = in.nextInt();
            Graphics g = frame.getGraphics();
            g.drawOval(x, y, 2 * circleRadius, 2 * circleRadius);
            double circleArea = myCircle.area(circleRadius);
            areas.add(circleArea);
            double circlePerimeter = myCircle.perimeter(circleRadius);
            perimeters.add(circlePerimeter);
        });

        JButton squareButton = new JButton("Draw Square");
        squareButton.addActionListener(e -> {
            System.out.println("Please give the starting coordinates and edge length for the square:");
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            int y = in.nextInt();
            int squareEdge = in.nextInt();
            Graphics g = frame.getGraphics();
            g.drawRect(x, y, squareEdge, squareEdge);
            double squareArea = mySquare.area(squareEdge);
            areas.add(squareArea);
            double squarePerimeter = mySquare.perimeter(squareEdge);
            perimeters.add(squarePerimeter);
        });

        JButton sumUp = new JButton("Sum Up");
        sumUp.addActionListener(e -> {
            areaSum.set(areas.stream().mapToDouble(i -> i).sum());
            perimeterSum.set(perimeters.stream().mapToDouble(i -> i).sum());
            System.out.printf("Total areas: %.2f%n", areaSum.get());
            System.out.printf("Total perimeters: %.2f%n", perimeterSum.get());

        });

        panel1.add(sumUp);
        panel1.add(reset);
        panel2.add(rectangleButton);
        panel2.add(triangleButton);
        panel2.add(circleButton);
        panel2.add(squareButton);

        frame.getContentPane().add(BorderLayout.SOUTH, panel1);
        frame.getContentPane().add(BorderLayout.NORTH, panel2);
        frame.setVisible(true);

    }
}