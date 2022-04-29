package wzorceProjektowe.behavioral.observer;

public class WeatherNotifier implements Listener{



    @Override
    public void show(Weather weather) {
        System.out.println("Today temperature: " + weather.getTemperature() +" oC");
        System.out.println("Today pressure: " + weather.getPressure() +" hPas");
        System.out.println("Today rainParameter: " + weather.getRainParameter() +" mm");
    }
}
