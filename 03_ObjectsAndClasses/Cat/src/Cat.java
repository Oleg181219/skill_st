
public class Cat {

    private static double count; //статическая переменная. Делаем ее приватной. Доступ через геттер/сеттер
    private static final int NUMBER_OF_EYES = 2;
    private static final int MIN_WEIGHT = 1000;
    private static final int MAX_WEIGHT = 9000;
    private double originWeight;
    private double weight;
    private double summF;
    private Colour catColour;

    //----------тут конструкторы----///
    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
        System.out.println(count + " cat");
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
    }


    //-----------геттеры/сеттеры-----////
    public static double getCount() {
        return count;
    }

    public static void setCount(double count) {
        Cat.count = count;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSummF() {
        return summF;
    }


    public Colour getCatColour() {
        return catColour;
    }

    public void setCatColour(Colour catColour) {
        this.catColour = catColour;
    }


    //--------другие методы-------///
    public Cat copyCat() { //метод копирования
        Cat cat = new Cat(); //создаем нового кота
        cat.setWeight(weight); //присваиваем такие же свойства как и у теущего кота
        cat.setCatColour(catColour);
        return cat; //возвращаем кота
    }


    public void meow() {
        if (getStatus().equals("Dead") | getStatus().equals("Exploded")) {
            weight = weight - 1;
            System.out.println("Meow");
        }
    }

    public void pee() {
        if (getStatus().equals("Dead") | getStatus().equals("Exploded")) {
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


    public void drink(int amount) {
        if (getStatus().equals("Dead") | getStatus().equals("Exploded")) {
            weight = weight + amount;
        }
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

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", catColour=" + catColour +
                '}';
    }

}