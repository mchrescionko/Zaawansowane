package wzorceProjektowe.behavioral.observer;

public class Weather {


    private double temperature;
    private double pressure;
    private double rainParameter;

    public Weather(double temperature, double pressure, double rainParameter) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.rainParameter = rainParameter;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getRainParameter() {
        return rainParameter;
    }
}
