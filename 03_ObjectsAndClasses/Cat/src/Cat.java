
public class Cat {

    public static double count; //статическая переменная
    public static final int NUMBER_OF_EYES = 2;
    public static final int MIN_WEIGHT = 1000;
    public static final int MAX_WEIGHT = 9000;
    private double originWeight;
    private double weight;
    private double minWeight;
    private double maxWeight;
    private double summF;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
        System.out.println(count + " cat");

    }

    public static double getCount() {
        return count;
    }



    public void meow() {
        if (weight >= minWeight & weight <= maxWeight) {
            weight = weight - 1;
            System.out.println("Meow");
        }

    }

    public void pee() {
        if (weight >= minWeight & weight <= maxWeight) {
            weight = weight - (weight / 33);
            System.out.println("pee");
        }
    }

    public void feed(int amount) {
        if (weight >= minWeight & weight <= maxWeight) {
            weight += amount;
            summF += amount;
        }

    }

    public double getFood() {
        return summF;
    }

    public void drink(int amount) {
        if (weight >= minWeight & weight <= maxWeight) {
            weight = weight + amount;
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}