package wzorceProjektowe.behavioral.observer2;

public class TvNews implements Observer {

    @Override
    public void updateForecast(WeatherForecast weatherForecast) {
        System.out.println("Telewizja - nowa prognoza pogody: temperatura: "+weatherForecast.temperature);
    }
}
