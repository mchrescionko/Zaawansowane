package refleksja2;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class Temperature{
    public Weather weather;
    public int intField5;
    public int intField6;

    public Temperature(Weather weather, int intField1, int intField2) {
        super();
        this.weather = weather;
        this.intField5 = intField1;
        this.intField6 = intField2;
    }

    public Weather getWeather() {
        return weather;
    }

    public int getIntField5() {
        return intField5;
    }

    public int getIntField6() {
        return intField6;
    }
}
