public class Transport {

    public static void main(String[] args) {
        double numberOfBox = 900;
        int car = 0;
        int cont = 0;
        int box = 0;
        double c = 0;
        double boxOnCar = countingСars.getBoxesInContainer() * countingСars.getContainersInTheTruck();

        for (c = 0; c <= numberOfBox; c++) {
            if ((c % boxOnCar) == 0) {
                car++;
                System.out.println("Грузовик - " + car);
            }
            if ((c % 27) == 0) {
                cont++;
                System.out.println("\t" + "Контейнер - " + cont);
            }
            if (box <= numberOfBox) {
                box++;
                System.out.println("\t" + "\t" + "Коробка - " + box);
            }

        }
    }
}
