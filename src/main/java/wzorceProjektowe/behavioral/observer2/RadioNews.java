package wzorceProjektowe.behavioral.observer2;

public class RadioNews implements Observer{

    @Override
    public void updateForecast(WeatherForecast weatherForecast) {
        System.out.println("Radio - nowa prognoza pogody: temperatura: "+weatherForecast.temperature);
    }


}
