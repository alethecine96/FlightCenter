import java.util.Scanner;

public class Flight {
    private int departurehour;
    private int idFlight;
    private int numberOfPassengers;
    private AbstractPlane abstractPlane;
    private Airport airportdeparture;
    private Airport airportarrive;
    private LandingStrip landingStrip;
    private boolean inflight;
    private int houroffly;
    private boolean isWaitingforLanding;
    private int lenghtofflight;


    public Flight(Airport airportdeparture, Airport airportarrive, AbstractPlane abstractPlane, int numberOfPassengers, int departurehour) {
        this.departurehour = departurehour;
        this.numberOfPassengers = numberOfPassengers;
        this.abstractPlane = abstractPlane;
        this.airportdeparture = airportdeparture;
        this.airportarrive = airportarrive;
        idFlight = (int)(Math.random()*10000);
    }


    public int getDeparturehour() {
        return departurehour;
    }

    public void setDeparturehour(int departurehour) {
        this.departurehour = departurehour;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public boolean isWaitingforLanding() {
        return isWaitingforLanding;
    }

    public void setWaitingforLanding(boolean waitingforLanding) {
        isWaitingforLanding = waitingforLanding;
    }

    public void setLenghtofflight(int lenghtofflight) {
        this.lenghtofflight = lenghtofflight;
    }

    public void setLandingStrip(LandingStrip landingStrip) {
        this.landingStrip = landingStrip;
    }

    public Airport getAirportdeparture() {
        return airportdeparture;
    }

    public Airport getAirportarrive() {
        return airportarrive;
    }

    public LandingStrip getLandingStrip() {
        return landingStrip;
    }

    public boolean isInflight() {
        return inflight;
    }

    public void setInflight(boolean inflight) {
        this.inflight = inflight;
    }

    public int getHouroffly() {
        return houroffly;
    }

    public void setHouroffly(int houroffly) {
        this.houroffly = houroffly;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void takeoff() {
        System.out.println("Il volo " + getIdFlight() + " con a bordo "+numberOfPassengers+" passeggeri sta decollando dalla pista numero "+ (getLandingStrip().getNumber()+1));
        inflight=true;
        getLandingStrip().setFull(true);
        for(int j=0;j<30;j++) {
            System.out.print("-");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void land(){
        System.out.println("Il volo " + getIdFlight() + " sta atterrando sulla pista numero " + (getLandingStrip().getNumber()+1));
        System.out.println("");
        getLandingStrip().setFull(true);
        inflight = false;
    }
}
