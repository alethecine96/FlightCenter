abstract class Subject {
    Observer observer;
    void notifyObserver(){
        observer.update();
    }
}
