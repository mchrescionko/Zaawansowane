package refleksja2;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class Person {
    public String name;
    public String [] imiona;

    public Person(String name, String[] imiona) {
        this.name = name;
        this.imiona = imiona;
    }

    public String getName() {
        return name;
    }

    public String[] getImiona() {
        return imiona;
    }
}
