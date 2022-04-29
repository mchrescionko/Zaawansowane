package plikiSerializacja;

import java.io.Serializable;
import java.util.Objects;

public final class MyObject2 implements Serializable {
    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public MyObject2() {
    }

    public MyObject2(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyObject2{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject2 myObject2 = (MyObject2) o;
        return number == myObject2.number && Objects.equals(name, myObject2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
