import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime twoHours = nowTime.plusHours(2);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(nowTime.getHour() + ":" + nowTime.getMinute()+"-текущее время");

        airport.getTerminals().stream().map(Terminal::getFlights).flatMap(Collection::stream).filter(flight ->
        {
            LocalDateTime timeFlight = toLocalTime(flight.getDate());
            if (flight.getType().equals(Flight.Type.DEPARTURE))
                if (timeFlight.isAfter(nowTime))
                    if (timeFlight.isBefore(twoHours))
                        return true;
            return false;
        })
                .forEach(flight ->
                        {
                            LocalDateTime timeFlight = toLocalTime(flight.getDate());
                            System.out.println(timeFlight.format(format) + "\t" + flight.getAircraft().getModel() +
                                    "\t" + flight.getType());
                        }
                );

    }

    private static LocalDateTime toLocalTime(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}

