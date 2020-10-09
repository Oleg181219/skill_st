import java.text.DecimalFormat;

public class temperature {
    private static final int NUM_PATIENTS = 30;
    private static final int MIN_TEMPERATURE = 32;
    private static final int MAX_TEMPERATURE = 40;
    private static final float MIN_HEALTHY_TEMPERATURE = (float) 36.2;
    private static final float MAX_HEALTHY_TEMPERATURE = (float) 36.9;
    static float middleTemp = 0;
    static int healthyPatients= 0;
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##.##");
        float[] tempArray = new float[NUM_PATIENTS];
        for (int i = 0; i < NUM_PATIENTS; i++) {
            float temperature = (float) (MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * Math.random());
            tempArray[i] = temperature;
            middleTemp += temperature;
            if ((temperature >= MIN_HEALTHY_TEMPERATURE) & (temperature <= MAX_HEALTHY_TEMPERATURE)){
                healthyPatients++;
            }
        }
        System.out.print("Температуры по больнице: ");
        for (int j = 0; j <NUM_PATIENTS;j++){
            System.out.print(df.format(tempArray[j])+" ");
        }
        System.out.println("\nСредняя температура по больнице: " + df.format(middleTemp / NUM_PATIENTS));
        System.out.println("Количество здоровы пациентов: " + healthyPatients);

    }
}



