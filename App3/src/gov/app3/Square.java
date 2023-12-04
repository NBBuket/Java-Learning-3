package gov.app3;

class Square implements RegularShapes {
    public double area(double x) {
        System.out.println("Square area: " + (x * x));
        return x * x;
    }
    public double perimeter(double x) {
        System.out.println("Square perimeter: " + (4 * x));
        return 4 * x;
    }
}
