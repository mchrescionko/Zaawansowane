package zadaniaZStreamo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyPerson extends Person{

    public MyPerson(String name) {
        super(name);
    }

    @Override
    protected int getRandomCash() {
        return (int)(Math.random()*100)+1;
    }

    @Override
    public LocalDate getRandomBirthDate() {
//        return LocalDate.of(2000,1,2);
        return LocalDate.now().minusDays((int)(Math.random()*100000)+1);
    }

    @Override
    public int getAge() {
        return (int)getBirthDate().until(LocalDate.now(), ChronoUnit.YEARS);
    }
}
