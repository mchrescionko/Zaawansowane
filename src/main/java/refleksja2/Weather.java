package refleksja2;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Weather {
    public int intField1;
    public int intField2;
    public String stringField1;
    public String stringField2;
    public Weather newObject;
    public int [] tabInt;
    public Temperature temperature;

    public Temperature getTemperature() {
        return temperature;
    }

    public Weather(int intField1, int intField2, String stringField1, String stringField2, Weather newObject, int[] tabInt, Temperature temperature) {
        this.intField1 = intField1;
        this.intField2 = intField2;
        this.stringField1 = stringField1;
        this.stringField2 = stringField2;
        this.newObject = newObject;
        this.tabInt = tabInt;
        this.temperature = temperature;
    }

    public Weather(int intField1, int intField2, String stringField1, String stringField2, Weather newObject, int[] tabInt) {
        this.intField1 = intField1;
        this.intField2 = intField2;
        this.stringField1 = stringField1;
        this.stringField2 = stringField2;
        this.newObject = newObject;
        this.tabInt = tabInt;
    }

    public Weather(int intField1, int intField2, String stringField1, String stringField2) {
        this.intField1 = intField1;
        this.intField2 = intField2;
        this.stringField1 = stringField1;
        this.stringField2 = stringField2;
    }

    public Weather(int intField1, int intField2, String stringField1, String stringField2, Weather newObject) {
        this.intField1 = intField1;
        this.intField2 = intField2;
        this.stringField1 = stringField1;
        this.stringField2 = stringField2;
        this.newObject = newObject;
    }



    public Weather getNewObject() {
        return newObject;
    }

    public int[] getTabInt() {
        return tabInt;
    }

    public int getIntField1() {
        return intField1;
    }

    public int getIntField2() {
        return intField2;
    }

    public String getStringField1() {
        return stringField1;
    }

    public String getStringField2() {
        return stringField2;
    }
}
