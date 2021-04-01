class Time extends Subject{
    private static Time time;
    private int hour = 0;
    private Time(Observer observer) {
        this.observer = observer;
    }

    static Time createTime(Observer observer){
        if(time==null)
            time = new Time(observer);
        return time;
    }

    void startTime(){
        while(hour !=24){
            waitSec(3);
            notifyObserver();
            hour++;
        }
    }

    void waitSec(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    int getHour() {
        return hour;
    }
}
