package wzorceProjektowe.structural.adapter.inside;

public class UKtoContinentalAdapter implements ContinentalDevice{

    private UKDevice device;

    public UKtoContinentalAdapter(UKDevice device) {
        this.device = device;
    }

    @Override
    public void on() {
        device.powerOn();
    }
}
