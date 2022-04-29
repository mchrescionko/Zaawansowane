package wzorceProjektowe.behavioral.observer2;

public class Main {
    public static void main(String[] args) {
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setPressure(1015);
        weatherForecast.setTemperature(19);

        RadioNews radioNews = new RadioNews();
        TvNews tvNews = new TvNews();

        weatherForecast.registerObserver(radioNews);
        weatherForecast.registerObserver(tvNews);

        weatherForecast.notifyObservers();

    }
}
