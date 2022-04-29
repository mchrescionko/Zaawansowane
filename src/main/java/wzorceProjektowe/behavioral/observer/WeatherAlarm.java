package wzorceProjektowe.behavioral.observer;

public class WeatherAlarm implements Listener{

    @Override
    public void show(Weather weather) {
        if(weather.getTemperature()>30){
            System.out.println("uwaga! Temperatura powyzej 30oC!");
        }
    }

}
