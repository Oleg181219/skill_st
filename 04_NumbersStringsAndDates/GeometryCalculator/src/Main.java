public class Main {
    public static void main(String[] args) {
        System.out.println("Circle Square");
        System.out.println(GeometryCalculator.getCircleSquare(3));
        System.out.println(GeometryCalculator.getCircleSquare(-5));
        System.out.println(GeometryCalculator.getCircleSquare(6.56));

        System.out.println("\nSphere Volume");
        System.out.println(GeometryCalculator.getSphereVolume(2));
        System.out.println(GeometryCalculator.getSphereVolume(5.6));
        System.out.println(GeometryCalculator.getSphereVolume(1));

        System.out.println("\nis Triangle Right");
        System.out.println(GeometryCalculator.isTriangleRightAngled(4, 5, 6));
        System.out.println(GeometryCalculator.isTriangleRightAngled(1, 2, 3));
        System.out.println(GeometryCalculator.isTriangleRightAngled(5, 5, 11));



        System.out.println("\nTriangle Square");
        System.out.println(GeometryCalculator.getTriangleSquare(2.0, 2.0, 10.0));
        System.out.println(GeometryCalculator.getTriangleSquare(7.0, 7.0, 8.10));
        System.out.println(GeometryCalculator.getTriangleSquare(15.0, 7.0, 8.10));
    }
}
