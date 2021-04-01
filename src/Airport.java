import java.util.ArrayList;


public class Airport {
    private ArrayList<LandingStrip> landingStrips = new ArrayList<>();
    private String name;
    private double latitudine;
    private double longitudine;

    Airport(String name,int landing, double latitudine, double longitudine){
        for(int i=0; i<landing; i++){
            landingStrips.add(new LandingStrip(i));
        }
        this.name = name;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    String getName() {
        return name;
    }

    ArrayList<LandingStrip> getLandingStrips() {
        return landingStrips;
    }

    double getLatitudine() {
        return latitudine;
    }

    double getLongitudine() {
        return longitudine;
    }

    boolean getFullLanding(){
        for (LandingStrip landingStrip : landingStrips){
            if(!landingStrip.getFull()){
                return false;
            }
        }
        return true;
    }
}
