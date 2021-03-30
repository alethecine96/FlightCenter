import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {
    private Flight flighttest;
    private Airport airportstart;
    private Airport airportarrive;
    private PlaneCreator planeCreator;

    @BeforeEach
    void setFlighttest(){
        airportstart = new Airport("Partenza", 2, 0, 0);
        airportarrive = new Airport("Arrivo", 2, 0, 0);
        planeCreator = new PlaneCreator();
        flighttest = new Flight(airportstart, airportarrive, planeCreator.createPlane("LITTLE"),50, 2 );
    }

    @Test
    void flighttest(){
        assertEquals(flighttest.getNumberOfPassengers(), 50);
        assertEquals(flighttest.getDeparturehour(), 2);
    }

    @Test
    void landTakeOffTest(){
        flighttest.setLandingStrip(airportstart.getLandingStrips().get(0));
        flighttest.takeoff();
        assertTrue(flighttest.isInflight());
        assertEquals(flighttest.getLandingStrip().getNumber(), 0);
        flighttest.land();
        assertFalse(flighttest.isInflight());
    }
}
