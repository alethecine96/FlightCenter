import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {
    private Airport airportTest;

    @BeforeEach
    void setAirportTest(){
        airportTest = new Airport("Test", 5, 0, 0);
    }

    @Test
    void getName(){assertEquals("Test", airportTest.getName());}

    @Test
    void getLandingFull(){
        for(LandingStrip landingStrip : airportTest.getLandingStrips()){
            assertFalse(airportTest.getFullLanding());
            landingStrip.setFull(true);
        }
        assertTrue(airportTest.getFullLanding());
    }
}
