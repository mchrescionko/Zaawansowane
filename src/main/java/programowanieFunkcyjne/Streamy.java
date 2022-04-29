package programowanieFunkcyjne;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Streamy {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Kot");
        stringList.add("Pies");
        stringList.add("Bocian");
        stringList.add("Zółw");
        stringList.add("Jeż");
        stringList.add("Małpa");

//        stringList.forEach(new MyConsumer());
//
//        stringList.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });


        stringList.forEach(s-> System.out.println(s));

        //stringList.removeIf(s-> s.length()>5);
        System.out.println();
        stringList.forEach(s-> System.out.println(s));

        Stream <String> stream = stringList.stream();
        Stream <String> stream2 = stream.filter(s-> s.length()>5);
        Stream <String> stream3 = stream2.sorted((s1,s2) -> s1.compareTo(s2));
        stream3.forEach(s-> System.out.println(s));

        System.out.println(stringList);
        stringList.stream()
                .filter(s-> s.length()>3)
                .sorted()
                .forEach(s-> System.out.println(s));




    }
}
