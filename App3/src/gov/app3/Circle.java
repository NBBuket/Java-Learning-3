package gov.app3;

class Circle implements RegularShapes {

    static final double PI = 3.14;
    public double area(double x) {
        System.out.println("Circle area: " + (2 * x * PI));
        return 2 * x * PI;
    }
    public double perimeter(double x) {
        System.out.println("Circle perimeter: " + (x * x * PI));
        return x * x * PI;
    }
}
