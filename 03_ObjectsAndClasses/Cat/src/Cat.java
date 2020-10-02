
public class Cat {

    public static double count; //статическая переменная
    private static final int NUMBER_OF_EYES = 2;
    private static final int MIN_WEIGHT = 1000;
    private static final int MAX_WEIGHT = 9000;
    private double originWeight;
    private double weight;
    private double summF;

    Colour catColour = Colour.Agouti;

    public void setCatColour (Colour catColour){
       this.catColour = catColour;
    }

    public Colour getCatColour() {
        return catColour;
    }


    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
        System.out.println(count + " cat");
    }

    public Cat (double weight) {
        this();
        this.weight = weight;
    }

    public static double getCount() {
        return count;
    }

    public void meow() {
        if (getStatus().equals("Dead") | getStatus().equals("Exploded")) {
            weight = weight - 1;
            System.out.println("Meow");
        }

    }

    public void pee() {
        if ( getStatus().equals("Dead") | getStatus().equals("Exploded")) {
            weight = weight - (weight / 33);
            System.out.println("pee");
        }
    }

    public void feed(int amount) {
        if (getStatus().equals("Dead") | getStatus().equals("Exploded")) {
            weight += amount;
            summF += amount;
        }
    }

    public double getFood() {
        return summF;
    }

    public void drink(int amount) {
        if (getStatus().equals("Dead") | getStatus().equals("Exploded")) {
            weight = weight + amount;
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}