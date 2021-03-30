import java.util.ArrayList;


public class Airport {
    private ArrayList<LandingStrip> landingStrips = new ArrayList<>();
    private String name;
    double latitudine;
    double longitudine;

    public Airport(String name,int landing, double latitudine, double longitudine){
        for(int i=0; i<landing; i++){
            landingStrips.add(new LandingStrip(i));
        }
        this.name = name;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public String getName() {
        return name;
    }

    public ArrayList<LandingStrip> getLandingStrips() {
        return landingStrips;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public boolean getFullLanding(){
        for (LandingStrip landingStrip : landingStrips){
            if(!landingStrip.getFull()){
                return false;
            }
        }
        return true;
    }
}
