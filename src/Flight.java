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


    Flight(Airport airportdeparture, Airport airportarrive, AbstractPlane abstractPlane, int numberOfPassengers, int departurehour) {
        this.departurehour = departurehour;
        this.numberOfPassengers = numberOfPassengers;
        this.abstractPlane = abstractPlane;
        this.airportdeparture = airportdeparture;
        this.airportarrive = airportarrive;
        idFlight = (int)(Math.random()*10000);
    }


    int getDeparturehour() {
        return departurehour;
    }

    void setDeparturehour(int departurehour) {
        this.departurehour = departurehour;
    }

    int getIdFlight() {
        return idFlight;
    }

    boolean isWaitingforLanding() {
        return isWaitingforLanding;
    }

    void setWaitingforLanding(boolean waitingforLanding) {
        isWaitingforLanding = waitingforLanding;
    }

    void setLenghtofflight(int lenghtofflight) {
        this.lenghtofflight = lenghtofflight;
    }

    void setLandingStrip(LandingStrip landingStrip) {
        this.landingStrip = landingStrip;
    }

    Airport getAirportdeparture() {
        return airportdeparture;
    }

    Airport getAirportarrive() {
        return airportarrive;
    }

    LandingStrip getLandingStrip() {
        return landingStrip;
    }

    boolean isInflight() {
        return inflight;
    }

    void setInflight(boolean inflight) {
        this.inflight = inflight;
    }

    int getHouroffly() {
        return houroffly;
    }

    void setHouroffly(int houroffly) {
        this.houroffly = houroffly;
    }

    int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    void takeoff() {
        System.out.println("Il volo " + getIdFlight() + " con a bordo "+numberOfPassengers+" passeggeri sta decollando dalla pista numero "+ (getLandingStrip().getNumber()+1));
        abstractPlane.printplane();
        inflight=true;
        getLandingStrip().setFull(true);
        System.out.println("Decollo completato");
    }

    void land(){
        System.out.println("Il volo " + getIdFlight() + " sta atterrando sulla pista numero " + (getLandingStrip().getNumber()+1));
        abstractPlane.printplane();
        System.out.println("Atterraggio completato");
        getLandingStrip().setFull(true);
        inflight = false;
    }
}
