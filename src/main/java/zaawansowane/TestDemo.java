package zaawansowane;


import java.time.LocalDateTime;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car(2);
        car.przejazd();
        System.out.println(car.getPrzebieg());

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1.getDayOfWeek());
    }
}
