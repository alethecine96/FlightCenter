public class BigPassengerPlane extends AbstractPlane {
    BigPassengerPlane() {
        super();
        setSpeed(750);
        setRange(3000);
    }

    @Override
    void printplane(){
        System.out.println("nome aereo: BIG velocità "+getSpeed()+" km/h autonomia "+getRange()+" km");
        System.out.println("Tempo di attesa esecuzione operazione: 5 secondi");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
