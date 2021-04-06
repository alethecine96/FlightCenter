public class LittlePassengerPlane extends AbstractPlane {
    LittlePassengerPlane() {
        super();
        setSpeed(1500);
        setRange(1200);

    }

    @Override
    void printplane(){
        System.out.println("nome aereo: LITTLE con velocità "+getSpeed()+" km/h e autonomia "+getRange()+" km");
        System.out.println("Tempo di attesa esecuzione operazione: 2 secondi");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
