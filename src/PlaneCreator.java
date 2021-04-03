public class PlaneCreator {

    AbstractPlane createPlane(String plane){
        switch (plane){
            case "LITTLE":
                return new LittlePassengerPlane();
            case "MID":
                return new MidPassengerPlane();
            case "BIG":
                return new BigPassengerPlane();
        }
        return null;
    }
}
