import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightManagerTest {
    private FlightManager flightManagerTest;
    private ArrayList<Airport> airports;

    @BeforeEach
    void setFlightManagerTest(){
        flightManagerTest = new FlightManager();
        airports = new ArrayList<>();
    }

    @Test
    void airportCreation() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./File/Coordinate"));
        while (scanner.hasNextLine()) {
            airports.add(new Airport(scanner.next(),scanner.nextInt(), flightManagerTest.getCoordinate(scanner.nextInt(), scanner.nextInt(),scanner.nextInt()), flightManagerTest.getCoordinate(scanner.nextInt(), scanner.nextInt(),scanner.nextInt())));
        }
        for(Airport airport: airports) {
            for (Airport airport1 : airports) {
                int distance = (int) (flightManagerTest.getDistance(airport.getLatitudine(), airport.getLongitudine(), airport1.getLatitudine(), airport1.getLongitudine()));
                int distance1 = (int) (flightManagerTest.getDistance(airport1.getLatitudine(), airport1.getLongitudine(), airport.getLatitudine(), airport.getLongitudine()));
                assertEquals(distance, distance1);
            }
        }
        Scanner scanner2 = new Scanner(new File("./File/Coordinate"));
        ArrayList<String> airportName = new ArrayList<>();
        while(scanner2.hasNextLine()){
            airportName.add(scanner2.next());
            scanner2.nextLine();
        }
        int i = 0;
        for(Airport airport3: airports){
            assertEquals(airport3.getName(), airportName.get(i));
            i++;
        }
    }
}
