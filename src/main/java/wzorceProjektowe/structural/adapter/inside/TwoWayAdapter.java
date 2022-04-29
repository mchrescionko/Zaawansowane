package wzorceProjektowe.structural.adapter.inside;

public class TwoWayAdapter implements UKDevice, ContinentalDevice {

    UKDevice ukDevice;
    ContinentalDevice continentalDevice;

    @Override
    public void on() {
        ukDevice.powerOn();
    }

    @Override
    public void powerOn() {
        continentalDevice.on();
    }
}
