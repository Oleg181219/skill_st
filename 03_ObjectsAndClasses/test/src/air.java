import com.skillbox.airport.Airport;

public class air {


    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        System.out.println(airport.getAllAircrafts());
        System.out.println("Всего самолетов - " + airport.getAllAircrafts().size());
    }
}
