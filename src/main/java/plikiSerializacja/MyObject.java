package plikiSerializacja;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class MyObject implements Serializable {
    private String name;
    private int myNumber;
    @JsonProperty("get_my_number2")
    private int getMyNumber2;
    // maszyna wirtualna zawsze tworzy nowy numer po zmianie ciala klasy (np. dodanie metody, zmiana ciala metody, kazda zmiana generalnie)
    public static final long serialVersionUID = 5975223532550657697l;
    //transient - wylacza pole z serializacji
//    private transient Scanner scanner = new Scanner(System.in);

    private MyObject2 myObject2l;

    public MyObject(String name, int myNumber) {
        this.name = name;
        this.myNumber = myNumber;
    }

    public MyObject() {
    }

    public MyObject(String name, int myNumber, MyObject2 myObject2l) {
        this.name = name;
        this.myNumber = myNumber;
        this.myObject2l = myObject2l;
    }

    public String getName() {
        return name;
    }

    public int getMyNumber() {
        return myNumber;
    }

    public int getGetMyNumber2() {
        return getMyNumber2;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public MyObject2 getMyObject2l() {
        return myObject2l;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return myNumber == myObject.myNumber && Objects.equals(name, myObject.name) && Objects.equals(myObject2l, myObject.myObject2l);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, myNumber, myObject2l);
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", myNumber=" + myNumber +
                ", getMyNumber2=" + getMyNumber2 +
                ", myObject2l=" + myObject2l +
                '}';
    }

    public void sayHello(String ...tab){
        for (String s : tab) {
            System.out.println(s);
        }

    }


}
