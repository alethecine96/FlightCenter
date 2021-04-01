import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightManager implements Observer {
    private PlaneCreator planeCreator;
    private ArrayList<Flight> fly;
    private Time time;
    private Airport airporttocontrol;
    public ArrayList<Airport> airports;
    private ArrayList<Flight> flights;
    FlightManager(){
        planeCreator = new PlaneCreator();
        fly = new ArrayList<>();
        airports = new ArrayList<>();
        time = Time.createTime(this);
        flights = new ArrayList<>();
    }

    void setairportcontrol() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("./File/Coordinate"));
        while (scanner.hasNextLine()) {
            airports.add(new Airport(scanner.next(),scanner.nextInt(), getCoordinate(scanner.nextInt(), scanner.nextInt(),scanner.nextInt()), getCoordinate(scanner.nextInt(), scanner.nextInt(),scanner.nextInt())));
        }
        System.out.println("Quale aereoporto vuoi controllare?");
        for(int j = 0; j<airports.size();j++){
            System.out.println((j+1)+" - "+airports.get(j).getName());
        }
        Scanner input = new Scanner(System.in);
        System.out.println(" ");
        int l = input.nextInt()-1;
        System.out.println("stai controllando l'aereoporto di "+airports.get(l).getName());
        airporttocontrol = airports.get(l);
    }

    void createFlight(){
        Airport airportdeparture = airporttocontrol;
        int[] departurehour = {1, 5, 8, 11, 17};
        int numberOfPassengers = 0;
        int departurehours = 0;
        Airport airportarrive;
        for (Airport airport : airports) {
            if (airport.getName().equals(airportdeparture.getName()))
                continue;
            numberOfPassengers = (int) (Math.random() * 250);
            departurehours = departurehour[(int) (Math.random() * (departurehour.length))];
            airportarrive = airport;
            double distance = getDistance(airportdeparture.getLatitudine(), airportdeparture.getLongitudine(), airport.getLatitudine(), airport.getLongitudine());
            String planeType;
            if (numberOfPassengers <= 75 && distance<1200) planeType = "LITTLE";
            else if (numberOfPassengers <= 150 && distance<1700) planeType = "MID";
            else planeType = "BIG";
            AbstractPlane plane = planeCreator.createPlane(planeType);
            Flight flight = new Flight(airportdeparture, airportarrive, plane, numberOfPassengers, departurehours);
            flight.setLenghtofflight((int)(distance));
            flight.setHouroffly((int)(Math.ceil(distance/plane.getSpeed())));
            flights.add(flight);
        }
    }

    void start(){
        time.startTime();
    }

    @Override
    public void update() {
        System.out.println("");
        System.out.println("Sono le ore " + time.getHour() + ":00");
        time.waitSec(3);
        for (Flight flight : flights) {
            if (flight.isInflight()) {
                int infly = (time.getHour() - flight.getDeparturehour());
                if (flight.getHouroffly() == infly) {
                    System.out.println("Il volo " + flight.getIdFlight() + " sta atterrando all'aereoporto di " + flight.getAirportarrive().getName());
                    System.out.println("in " + flight.getHouroffly() + " ore tornerà all'aereoporto di partenza");
                    System.out.println(" ");
                } else if (flight.getHouroffly() * 2 == infly || flight.isWaitingforLanding()) {
                    if(!flight.getAirportdeparture().getFullLanding()) {
                        System.out.println("");
                        System.out.println("Il volo " + flight.getIdFlight() + " è pronto per atterrare");
                        System.out.println("Selezionare una pista per l' atterraggio");
                        int landing = selectlandingstrip();
                        flight.setLandingStrip(airporttocontrol.getLandingStrips().get(landing));
                        flight.land();
                        time.waitSec(2);
                    }
                    else{
                        System.out.println("non posso atterrare ci sono tutte le piste piene, rimango in volo e effettuo un nuovo tentativo all'ora successiva");
                        flight.setWaitingforLanding(true);
                    }
                }
            }
            if (flight.getDeparturehour() == time.getHour()) {
                if (flight.getAirportdeparture().getFullLanding()) {
                flight.setDeparturehour(flight.getDeparturehour() + 1);
                } else {
                System.out.println("");
                System.out.println("Il volo "+flight.getAirportdeparture().getName()+" - "+flight.getAirportarrive().getName()+" con numero "+flight.getIdFlight()+" è pronto per partire");
                System.out.println("Selezionare una pista per il decollo");
                int landing = selectlandingstrip();
                flight.setLandingStrip(airporttocontrol.getLandingStrips().get(landing));
                flight.takeoff();
                time.waitSec(2);
                }
            }

        }
        for (LandingStrip landingStrip : airporttocontrol.getLandingStrips()) {
            landingStrip.setFull(false);
        }
    }

    double getDistance(double latitudestart, double longitudestart, double latitudearrive, double longitudearrive){
        double difference = (longitudestart-longitudearrive);
        double dist = Math.acos(Math.sin(latitudestart) * Math.sin(latitudearrive) + Math.cos(latitudestart) * Math.cos(latitudearrive) * Math.cos(difference)) * 6371;
        return dist;
    }

    double getCoordinate(double gradi, double primi, double secondi){
        double risultato;
        risultato = gradi+(primi/60)+(secondi/3600);
        double u = (risultato*2*3.14/360);
        return u;
    }

    int selectlandingstrip()  {
        for(int j = 0; j<airporttocontrol.getLandingStrips().size();j++){
            if(airporttocontrol.getLandingStrips().get(j).getFull())
                System.out.println("Pista n° "+(j+1)+" OCCUPATA");
            else
                System.out.println("Pista n° " +(j+1)+" LIBERA");
        }
        Scanner input = new Scanner(System.in);
        System.out.println(" ");
        int i = input.nextInt()-1;
        while(i>=airporttocontrol.getLandingStrips().size() || airporttocontrol.getLandingStrips().get(i).getFull() ) {
            System.out.println("La pista è già occupata o non esiste una pista con quel numero inserire un nuovo numero");
            i = input.nextInt()-1;
        }

        return i;
    }

}
