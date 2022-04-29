package wzorceProjektowe.templateMEthod;

public abstract class CarStartingSequence {
    public final void startCar(){
        fastenSeatBelts();
        startTheIgnition();
        setTheGear();
        go();
    }

    private void go(){
        System.out.println("Wciskamy pedal gazu");
    }

    private void fastenSeatBelts(){
        System.out.println("zapinamy pasy");
    }
    public abstract void setTheGear();
    public abstract void startTheIgnition();
}
