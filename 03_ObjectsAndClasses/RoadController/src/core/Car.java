package core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }

    public void setNumber (String number){
        this.number = number;
    }

    public String getNumber(){
        return number;
    }

    public void setHeight (int number){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public void setWeight (double number){
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public void setHasVehicle (Boolean hasVehicle){
        this.hasVehicle = hasVehicle;
    }

    public boolean getHasVehicle(){
        return hasVehicle;
    }

    public void setIsSpecial(Boolean isSpecial){
        this.isSpecial = isSpecial;
    }

    public boolean getIsSpecial(){
        return isSpecial;
    }
}