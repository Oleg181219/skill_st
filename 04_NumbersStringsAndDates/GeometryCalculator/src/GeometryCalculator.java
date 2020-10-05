public class GeometryCalculator {
    private static double pi = Math.PI;


    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        double circleSquare = pi * Math.pow(Math.abs(radius), 2);
        return circleSquare;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double SphereVolume = ((4 * pi * Math.pow(Math.abs(radius), 3)) / 3);
        return SphereVolume;
    }

    public static boolean isTriangleRightAngled(double a, double b, double c) {
        if (((a + b) > c) & ((a + c) > b) & ((b + c) > a)) {
            return true;
        } else
            return false;

    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTriangleRightAngled(a, b, c)) {
            double p = (a + b + c) / 2;
            double TriangleSquare = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return TriangleSquare;
        } else {

            return 0;
        }
    }
}
