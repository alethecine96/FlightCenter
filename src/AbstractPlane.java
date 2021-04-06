public abstract class AbstractPlane {
    private String planeName;
    private int planeId;
    private int speed;
    private int range;

    AbstractPlane(){
        planeId = (int)(Math.random()*1000000);
    }

    int getSpeed() {
        return speed;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    String getPlaneName() {
        return planeName;
    }

    int getRange() {
        return range;
    }

    void setRange(int range) {
        this.range = range;
    }

    void printplane(){};
}
