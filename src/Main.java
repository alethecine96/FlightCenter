import java.io.FileNotFoundException;

public class Main {
    //TODO inserire nei messaggi il tipo di aereo utilizzato dal volo

    public static void main(String[] args) throws FileNotFoundException {
        FlightManager flightManager = new FlightManager();
        flightManager.setairportcontrol();
        flightManager.createFlight();
        flightManager.start();
    }
}
