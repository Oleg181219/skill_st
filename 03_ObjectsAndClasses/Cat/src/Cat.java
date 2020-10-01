
public class Cat {

    public static double count; //статическая переменная

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
        weight = weight - 1;
        // System.out.println("Meow");
    }

    public void pee() {
        weight = weight - (weight / 33);
        //System.out.println("pee");
    }

    public void feed(int amount) {
        weight += amount;
        summF += amount;

    }

    public double getFood() {
        return summF;
    }

    public void drink(int amount) {
        weight = weight + amount;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            count = count - 0.5;
            return "Dead";
        } else if (weight > maxWeight) {
            count = count - 0.5;
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}