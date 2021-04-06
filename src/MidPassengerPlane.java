public class MidPassengerPlane extends AbstractPlane {
    MidPassengerPlane(){
        super();
        setSpeed(1000);
        setRange(1700);
    }

    @Override
    void printplane(){
        System.out.println("nome aereo: MID velocità "+getSpeed()+" km/h autonomia "+getRange()+" km");
        System.out.println("Tempo di attesa esecuzione operazione: 3,5 secondi");
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
