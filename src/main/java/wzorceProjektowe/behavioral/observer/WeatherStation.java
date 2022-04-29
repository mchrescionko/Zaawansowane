package wzorceProjektowe.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<Listener> listenerList = new ArrayList<>();

    public WeatherStation() {

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                measureWeather();
            }
        });
        thread.start();

    }

    public void addListener(Listener listener) {
        this.listenerList.add(listener);
    }

    public void sendNorification(Weather weather) {
        for (Listener listener : listenerList) {
            listener.show(weather);
        }
    }

    public void measureWeather() {

        double temperature = Math.random() * 50 + 1;
        double pressure = Math.random() * 200 + 900;
        double rainTemperature = Math.random() * 200 + 90;
        Weather weather = new Weather(temperature, pressure, rainTemperature);
        sendNorification(weather);
    }
}
