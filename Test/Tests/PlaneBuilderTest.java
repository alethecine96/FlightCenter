import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaneBuilderTest {
    private PlaneCreator testplaneCreator;

    @BeforeEach
    void setTestPlaneCreator(){
        testplaneCreator = new PlaneCreator();
        testplaneCreator.createPlane("LITTLE");
    }

    @Test
    void testPlaneCreation(){
        LittlePassengerPlane littlePassengerPlane = new LittlePassengerPlane(1500, 1200);
        MidPassengerPlane midPassengerPlane = new MidPassengerPlane(1000, 1700);
        MidPassengerPlane bigPassengerPlane = new MidPassengerPlane(750, 3000);
        assertEquals(littlePassengerPlane.getSpeed(), testplaneCreator.createPlane("LITTLE").getSpeed());
        assertEquals(littlePassengerPlane.getRange(), testplaneCreator.createPlane("LITTLE").getRange());
        assertEquals(midPassengerPlane.getSpeed(), testplaneCreator.createPlane("MID").getSpeed());
        assertEquals(midPassengerPlane.getRange(), testplaneCreator.createPlane("MID").getRange());
        assertEquals(bigPassengerPlane.getSpeed(), testplaneCreator.createPlane("BIG").getSpeed());
        assertEquals(bigPassengerPlane.getRange(), testplaneCreator.createPlane("BIG").getRange());

    }
}
