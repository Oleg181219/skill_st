
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double summF;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void pee()
    {
        weight = weight - ( weight/33);
        System.out.println("pee");
    }

    public int feed(int amount)
    {
        weight = weight + amount;
        return amount;
    }

    public double summFeed (int incomeFeed) {
        summF = summF + incomeFeed;
        return summF;
    }
    public double getFood()
    {
        return summF;
    }

    public void drink(int amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}