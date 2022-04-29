package wzorceProjektowe.behavioral.observer;

public class WeatherForecaster implements Listener{


    @Override
    public void show(Weather weather) {
        System.out.println("Jutro bedzie "+(weather.getTemperature()+5)+" oC");
        System.out.println("Jutro bedzie "+(weather.getPressure()+5)+" hPAs");
        System.out.println("Jutro bedzie "+(weather.getRainParameter()+5)+" mm");
    }
}
