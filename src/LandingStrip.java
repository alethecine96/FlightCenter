public class LandingStrip {
    private int number;
    private Boolean full = false;

    LandingStrip(int number) {
        this.number = number;
    }

    Boolean getFull() {
        return full;
    }

    void setFull(Boolean full) {
        this.full = full;
    }

    int getNumber() {
        return number;
    }
}
