public class Transport {

    public static void main(String[] args) {
        double numberOfBox = 1500;
        int car = 0;
        int cont = 0;
        int box = 0;

        double boxOnCar = countingСars.getBoxesInContainer() * countingСars.getContainersInTheTruck();

        for (double c = 0; c <= numberOfBox; c++) {
            if ((c % boxOnCar) == 0) {
                car++;
                System.out.println("Грузовик - " + car);
            }
            if ((c % 27) == 0) {
                cont++;
                System.out.println("\t" + "Контейнер - " + cont);
            }
            if (box <= (numberOfBox - 1)) {
                box++;
                System.out.println("\t" + "\t" + "Коробка - " + box);

            }

        }
        System.out.println("Необходимо грузовиков: " + car);
        System.out.println("Необходимо контейнеров: " + cont);
    }
}
