package gov.app3;
class Triangle implements RegularShapes {
    public double area(double x) {
        System.out.printf("Triangle area: %.2f%n", x * x * Math.sqrt(3) / 4);
        return x * x * Math.sqrt(3) / 4;
    }

    public double perimeter(double x) {
        System.out.println("Triangle perimeter: " + (3 * x));
        return 3 * x;
    }
}
