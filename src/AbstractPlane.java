public abstract class AbstractPlane {
    private String planeName;
    private int planeId;
    private int speed;
    private int range;

    public AbstractPlane(){
        planeId = (int)(Math.random()*1000000);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getPlaneName() {
        return planeName;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
