package zaawansowane;

public class Car {
    private int przebieg;

    public Car(int przebieg) {
        this.przebieg = przebieg;
    }

    public void przejazd(){
        przebieg +=100;
    }

    public int getPrzebieg() {
        return przebieg;
    }
}
