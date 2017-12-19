import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem on 23.05.2016.
 */
public class MeteoApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new SecondConsoleObserver());
        station.setMeasurements(25,760);
        station.setMeasurements(30,750);

    }
}

//interface Observable
interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

//ConcreteObservable
class MeteoStation implements Observed{
    int temperature;
    int pressure;
    List<Observer> observers=new ArrayList<>();

    public void setMeasurements(int t, int p){
        temperature=t;
        pressure=p;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:observers){
            o.handleEvent(temperature,pressure);
        }
    }
}

//interface Observer
interface Observer{
    void handleEvent(int temp,int presser);
}

//ConcreteObserver
class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Weather has been changed: temperature="+temp+" pressure="+presser);
    }
}

class SecondConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("temp="+temp+" pres="+presser);
    }
}

