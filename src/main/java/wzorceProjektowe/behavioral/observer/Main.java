package wzorceProjektowe.behavioral.observer;
//stworz klase weatherStation, ktora robi pomiary temperatury i cisnienia za pomoca measureWeather, ktora losuje te wartosci
public class Main {
    public static void main(String[] args) {
        WeatherNotifier weatherNotifier = new WeatherNotifier();
        WeatherForecaster weatherForecaster = new WeatherForecaster();
        WeatherStation weatherStation = new WeatherStation();
        WeatherAlarm weatherAlarm = new WeatherAlarm();
        weatherStation.addListener(weatherForecaster);
        weatherStation.addListener(weatherNotifier);
        weatherStation.addListener(weatherAlarm);

    }

}
