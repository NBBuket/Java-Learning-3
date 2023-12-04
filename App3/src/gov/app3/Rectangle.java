package gov.app3;

class Rectangle {
    public int area(int x, int y) {
        System.out.println("Rectangle area: " + (x * y));
        return x * y;
    }
    public int perimeter(int x, int y) {
        System.out.println("Rectangle perimeter: " + (2 * (x + y)));
        return 2 * (x + y);
    }

}
