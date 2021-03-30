public class LandingStrip {
    private int number;
    private Boolean full = false;

    public LandingStrip(int number) {
        this.number = number;
    }

    public Boolean getFull() {
        return full;
    }

    public void setFull(Boolean full) {
        this.full = full;
    }

    public int getNumber() {
        return number;
    }
}
