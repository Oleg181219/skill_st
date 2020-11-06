import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    List<Station> routeSameStation;
    List<Station> routeOnTheLine;
    List<Station> routeWithOneConnection;
    List<Station> routeWithTwoConnections;
    StationIndex stationIndex;
    RouteCalculator calculator;


    @Override
    protected void setUp() throws Exception {

        stationIndex = new StationIndex();
        route = new ArrayList<>();
        Line line4 = new Line(4, "Правобережная");
        Line line3 = new Line(3, "Невско-Василеостровская");
        Line line1 = new Line(1, "Кировско-Выборгская");

        Station station1 = new Station("Чернышевская", line1);
        Station station2 = new Station("Площадь Восстания", line1);

        Station station3 = new Station("Маяковская", line3);
        Station station4 = new Station("Площадь Александра Невского 1", line3);

        Station station5 = new Station("Площадь Александра Невского 2", line4);
        Station station6 = new Station("Новочеркасская", line4);
        Station station7 = new Station("Ладожская", line4);

        line1.addStation(station1);
        line1.addStation(station2);
        line3.addStation(station3);
        line3.addStation(station4);
        line4.addStation(station5);
        line4.addStation(station6);
        line4.addStation(station7);

        stationIndex.addLine(line1);
        stationIndex.addLine(line3);
        stationIndex.addLine(line4);

        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);

        stationIndex.addConnection(new ArrayList<>(Arrays.asList(station2,station3)));
        stationIndex.addConnection(new ArrayList<>(Arrays.asList(station4,station5)));

        calculator = new RouteCalculator(stationIndex);
        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);

    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);

    }

    public void testGetShortestRoute()
    {
        routeSameStation = new ArrayList<>();
        routeSameStation.add(stationIndex.getStation("Новочеркасская"));
        List<Station> actual = calculator.getShortestRoute(stationIndex.getStation("Новочеркасская", 4)
                , stationIndex.getStation("Новочеркасская", 4));
        assertEquals(routeSameStation,actual);
        System.out.println(routeSameStation);
        System.out.println(actual);
    }

    public void testRouteOnTheLine ()
    {
        routeOnTheLine = new ArrayList<>();
        routeOnTheLine.add(stationIndex.getStation("Площадь Александра Невского 2"));
        routeOnTheLine.add(stationIndex.getStation("Новочеркасская"));
        routeOnTheLine.add(stationIndex.getStation("Ладожская"));
        List<Station> actual = calculator.getShortestRoute(stationIndex.getStation("Площадь Александра Невского 2",
                4)
                , stationIndex.getStation("Ладожская", 4));
        assertEquals(routeOnTheLine, actual);
        System.out.println(routeOnTheLine);
        System.out.println(actual);
    }

    public void testRouteWithOneConnection ()
    {
        routeWithOneConnection = new ArrayList<>();

        routeWithOneConnection.add(stationIndex.getStation("Маяковская"));
        routeWithOneConnection.add(stationIndex.getStation("Площадь Александра Невского 1"));
        routeWithOneConnection.add(stationIndex.getStation("Площадь Александра Невского 2"));
        routeWithOneConnection.add(stationIndex.getStation("Новочеркасская"));
        routeWithOneConnection.add(stationIndex.getStation("Ладожская"));
        List<Station> actual = calculator.getShortestRoute(stationIndex.getStation("Маяковская", 3)
                , stationIndex.getStation("Ладожская", 4));
        assertEquals(routeWithOneConnection, actual);
        System.out.println(routeWithOneConnection);
        System.out.println(actual);
    }


    public void testRouteWithTwoConnections ()
    {
        routeWithTwoConnections = new ArrayList<>();
        routeWithTwoConnections.add(stationIndex.getStation("Чернышевская"));
        routeWithTwoConnections.add(stationIndex.getStation("Площадь Восстания"));
        routeWithTwoConnections.add(stationIndex.getStation("Маяковская"));
        routeWithTwoConnections.add(stationIndex.getStation("Площадь Александра Невского 1"));
        routeWithTwoConnections.add(stationIndex.getStation("Площадь Александра Невского 2"));
        routeWithTwoConnections.add(stationIndex.getStation("Новочеркасская"));
        routeWithTwoConnections.add(stationIndex.getStation("Ладожская"));
        List<Station> actual1 = calculator.getShortestRoute(stationIndex.getStation("Чернышевская", 1)
                , stationIndex.getStation("Ладожская", 4));
        int actual = actual1.size();
        assertEquals(routeWithTwoConnections.size(), actual);
        System.out.println(routeWithTwoConnections);
        System.out.println(actual);
    }
    @Override
    protected void tearDown() throws Exception {

    }


}
