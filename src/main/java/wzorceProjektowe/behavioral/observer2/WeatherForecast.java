package wzorceProjektowe.behavioral.observer2;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class WeatherForecast implements Observable {
    int temperature;
    int pressure;
    private Set<Observer> registeredObservers = new HashSet<Observer>();

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    @Override
    public void registerObserver(Observer observer) {
        registeredObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        registeredObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(2000);
                        for (Observer registeredObserver : registeredObservers) {
                            registeredObserver.updateForecast(WeatherForecast.this);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        thread.start();

    }
}
