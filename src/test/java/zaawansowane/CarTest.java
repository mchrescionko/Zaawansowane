package zaawansowane;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void przetestujPrzejazd(){
        //given
        Car car = new Car(2);

        //when
        car.przejazd();

        //then
        assertEquals(102,car.getPrzebieg());
    }
}