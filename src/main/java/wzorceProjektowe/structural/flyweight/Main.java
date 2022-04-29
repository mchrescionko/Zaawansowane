package wzorceProjektowe.structural.flyweight;

import wzorceProjektowe.structural.flyweight.flyweightInside.TeslaTank;
import wzorceProjektowe.structural.flyweight.flyweightInside.Riffleman;
import wzorceProjektowe.structural.flyweight.flyweightInside.Destroyer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Object> activeUnits = new ArrayList<>();

        for(int i=0;i<10000000;i++){
            activeUnits.add(new TeslaTank("tank", 10, 10, 10, 10, 10, 10, 10 ));
            activeUnits.add(new Riffleman("riffle", 10, 10, 10, 10, 10, 10, 10));
            activeUnits.add(new Destroyer(0,0));

        }

    }
}
