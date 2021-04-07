import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FlightManager flightManager = new FlightManager();
        flightManager.setairportcontrol();
        flightManager.createFlight();
        flightManager.start();
    }
}
