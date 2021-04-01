public class PlaneCreator {

    AbstractPlane createPlane(String plane){
        switch (plane){
            case "LITTLE":
                return new LittlePassengerPlane(1500, 1200);
            case "MID":
                return new MidPassengerPlane(1000, 1700);
            case "BIG":
                return new BigPassengerPlane(750, 3000);
        }
        return null;
    }
}
