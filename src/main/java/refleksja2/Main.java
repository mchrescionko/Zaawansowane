package refleksja2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.type.ObjectType;
import plikiSerializacja.jackson.Car;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, NoSuchFieldException {

        int[] xr = new int[]{1, 2, 3};
        Weather weather = new Weather(1, 2, "raz", "dwa", null, xr);

        Weather weather3 = new Weather(1, 2, "raz", "dwa", weather);
//        Weather weather4 = new Weather(1, 2, "raz", "dwa", weather);
        Weather weather5 = new Weather(1, 2, "raz", "dwa", weather);
        Temperature temperature = new Temperature(weather, 1, 2);
        Temperature temperature2 = new Temperature(weather, 11, 21);
        int[] x = new int[]{1, 2, 3, 4, 5};
        String[] nazwy = new String[]{"pierwsza", "druga"};
        Person person = new Person("imie", nazwy);
//        ObjectMapper objectMappertest = new ObjectMapper();
//
//        String json = objectMappertest.writeValueAsString(person);
//        System.out.println("json: "+json);

        Weather weather4 = new Weather(1, 2, "raz", "dwa", weather, x);
//        Weather weather5 = new Weather(1, 2, "raz", "dwa", weather, x, temperature);

        String[] imiona = new String[]{"jeden", "dwa"};
        Integer[] nogi = new Integer[]{2, 3, 4};
        Dog dog = new Dog("Pieseł", null, imiona, nogi, null);
        Dog dog2 = new Dog("blabla", dog, imiona, nogi, dog);


        List<Object> lista = new ArrayList<>();
        List<Weather> listaWeather = new ArrayList<>();

//        lista.add(dog2);
        lista.add(weather);
        lista.add(weather3);
        lista.add(weather5);
        lista.add(weather4);
//        lista.add(person);
//        lista.add(weather4);
//        lista.add(weather5);
//        lista.add(temperature);
//        lista.add(temperature2);

        listaWeather.add(weather);
        listaWeather.add(weather3);

        ;

        String fileName = "test13";
        zapisJackson(listaWeather, fileName);
        odczytJackson(fileName);

        zapis(lista, fileName);
//        odczyt(fileName);
//        odczytJackson(fileName);

//        odczyt();

    }

    private static void zapis(List<Object> lista, String fileName) throws FileNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.println("[");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("klasa: " + lista.get(i).getClass());
            System.out.println("lista.get(i): " + lista.get(i));
            nowyObiekt(printWriter, lista.get(i).getClass(), lista.get(i));
            if (i < lista.size() - 1) {
                printWriter.println(",");
            }
        }
        printWriter.println("]");
        printWriter.close();
    }

    public static void pola(Class clazzz) {
        Field[] fields = clazzz.getFields();
        System.out.println(fields);
    }

    private static void odczytJackson(String fileName) throws JsonProcessingException, FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String wholeString = "";
        while (scanner.hasNextLine()) {
            wholeString += scanner.nextLine();
        }
        System.out.println(wholeString);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Weather> weatherList = objectMapper.readValue(wholeString, new TypeReference<List<Weather>>() {
        });
        System.out.println(weatherList);
    }

    private static void zapisJackson(List<Weather> list, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(fileName), list);
    }

    private static void odczyt(String fileName) throws FileNotFoundException, NoSuchFieldException {
        List<Class> classList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        File file = new File(fileName);
        String allFileString = "";
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            allFileString+=scanner.nextLine();
        }

        String [] typesIntDouble = new String []{"Int", "Double"};

        allFileString = allFileString.replaceAll(" ", "");
        System.out.println("allString: "+allFileString);

        Field [] fields = Weather.class.getFields();
        char [] znaki = allFileString.toCharArray();
        for(int i=0;i<allFileString.length();i++){
            if(znaki[i]=='"'){
                String fieldName = "";
                i++;
                while(znaki[i]!='"'){
                    fieldName +=znaki[i];
                    i++;
                }
                System.out.println(fieldName);
                if("int".equals(Weather.class.getField(fieldName).getType().getSimpleName())){
                    classList.add(int.class);
                    i++;
                    i++;
                    String number = "";
                    while(znaki[i]!=','){
                        number +=znaki[i];
                        i++;
                    }
                    int value = Integer.parseInt(number);
                    objectList.add(value);
                    System.out.println("int value: "+value);
                }
                if("String".equals(Weather.class.getField(fieldName).getType().getSimpleName())){
                    classList.add(String.class);
                    i++;
                    i++;
                    i++;
                    String name = "";
                    while(znaki[i]!='"'){
                        name +=znaki[i];
                        i++;
                    }
                    i++;
                    objectList.add(name);
                    System.out.println("string value: "+name);
                }
                if(Weather.class.getField(fieldName).getType().isArray()){
                    classList.add(Weather.class.getField(fieldName).getClass());
                    if("int".equals(Weather.class.getField(fieldName).getClass().getSimpleName())){

//                        int [] intArray = new int [];

                    }
                }
            }
        }
//        List<Object> list = new ArrayList<>();
//        String line = scanner.nextLine();
//        line = scanner.nextLine();
//        while (scanner.hasNextLine()) {
//
//            System.out.println("scanner w odczycie: " + line);
//            if (line.equals("}")) {
//                line = scanner.nextLine();
//                System.out.println("znaleziono }");
//            }
//            if (line.equals("]")) {
//                System.out.println("koniec");
//                System.out.println(list);
//                return;
//            }
//            Weather weather = odczytNowyObiekt(file, scanner);
//            list.add(weather);
//            line = scanner.nextLine();
//            System.out.println("odczyt, po dodaniu do listy: " + line);
//        }
    }

    private static Weather odczytNowyObiekt(File file, Scanner scanner) throws FileNotFoundException {
        String line = scanner.nextLine();
        System.out.println(line);
        System.out.println(line.length());
        if (line.equals("{")) {
            line = scanner.nextLine();
            System.out.println("new line");
        }
        System.out.println("pierwsza linia: " + line);
        int intField1 = Integer.parseInt(line.substring(13, line.toCharArray().length - 1));
        line = scanner.nextLine();
        System.out.println(intField1);
        int intField2 = Integer.parseInt(line.substring(13, line.split("").length - 1));
        line = scanner.nextLine();
        String stringField1 = line.substring(17, line.split("").length - 2);
        line = scanner.nextLine();
        String stringField2 = line.substring(17, line.split("").length - 2);
        System.out.println("stringfield2: " + stringField2);
        line = scanner.nextLine();
        Weather newObject;
        System.out.println("przed new object: " + line);
        System.out.println("line length: " + line.length());

        if (line.length() == 16) {
            newObject = null;
        } else {
            newObject = odczytNowyObiekt(file, scanner);
        }
        Weather weather = new Weather(intField1, intField2, stringField1, stringField2, newObject);
        System.out.println("weather: " + weather);
        scanner.nextLine();
        return weather;

    }


    private static void nowyObiekt(PrintWriter printWriter, Class clazzz, Object o) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        Field[] fields = clazzz.getFields();
        System.out.println("klasa: " + clazzz);
        System.out.println("dlugosc tab fields: " + fields.length);
        List<String> typesList = listaZTypami();

        for (Field field : fields) {
            field.setAccessible(true);
        }
        Method[] methods = getMethods(clazzz, fields);

        printWriter.println("{");
        System.out.println("tu jestem 1");

        zapis(printWriter, o, fields, typesList, methods);
        printWriter.println("}");
    }

    private static void zapis(PrintWriter printWriter, Object o, Field[] fields, List<String> typesList, Method[] methods) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException {
        System.out.println("dwa: " + fields.length);
        for (int i = 0; i < fields.length; i++) {

            if (!typesList.contains(fields[i].getType().getSimpleName())) {
                nowyObiekt2(printWriter, o, fields[i], methods, i);

            } else if (fields[i].getType().isArray()) {
                System.out.println("trz");
                printWriterArray(printWriter, o, fields[i], methods[i]);

            } else {
                System.out.println("dwa");
                printWriterZwyklePole(printWriter, o, fields[i], methods[i]);

            }
            if (i < fields.length - 1) {
                printWriter.println(",");
            } else {
                printWriter.println("");
            }

        }
    }

    private static void printWriterZwyklePole(PrintWriter printWriter, Object o, Field field, Method method) throws IllegalAccessException, InvocationTargetException {
        System.out.println("typ metody: " + method.getReturnType().getSimpleName());
        System.out.println("nazwa metody: " + method.getName());
        System.out.println("nazwa pola: " + field.getName());

        System.out.println(o);
        System.out.println("metoda: " + method.invoke(o));
        printWriter.print("\"" + field.getName() + "\"" + ": " + ((method.getReturnType().getSimpleName().equals("String")) ? "\"" : "") + method.invoke(o).toString() + ((method.getReturnType().getSimpleName().equals("String")) ? "\"" : ""));
    }

    private static void nowyObiekt2(PrintWriter printWriter, Object o, Field field, Method[] methods, int i) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException {
        System.out.println("newobject");
        System.out.println("nazwa metody: " + methods[i].getName());
        System.out.println("obiekt: " + o);
        printWriter.print("\"" + field.getName() + "\":");

        Object innerObject = methods[i].invoke(o);

        nowyObiekt(printWriter, methods, i, innerObject);
    }

    private static void printWriterArray(PrintWriter printWriter, Object o, Field field, Method method) throws IllegalAccessException, InvocationTargetException {
        System.out.println("array");
        System.out.println(field.getName());
        printWriter.print("\"" + field.getName() + "\":");
        String[] nazwa = field.getName().split("");
        String[] nazwa2 = new String[nazwa.length - 2];
        String nazwaTypu = "";
        for (int i1 = 0; i1 < nazwa2.length; i1++) {
            printWriter.println();
            nazwa2[i1] = nazwa[i1];
            System.out.println("litera: " + nazwa2[i1]);
            nazwaTypu = nazwaTypu + nazwa2[i1];
        }
        System.out.println("nazwa polaff: " + field.getType().getComponentType().getSimpleName());

//

        printWriter.println("[");
        int x = 0;

        if (method.invoke(o) != null) {
            System.out.println(method.invoke(o));
            x = Array.getLength(method.invoke(o));
            System.out.println("cos: " + x);
        }


//        System.out.println("nazwa metody: "+method.getName());
//        System.out.println("metoda: "+method);
//        System.out.println("metoda ivoke "+method.invoke(o));
//        System.out.println("typ: "+field.getClass().getComponentType());

        String isString = "";
        System.out.println("nazwa: " + nazwaTypu);
        if (field.getType().getComponentType().getSimpleName().equals("String")) {
            System.out.println("nazwa typu " + nazwaTypu);
            System.out.println("stringi");
            isString = "\"";
        }

        for (int i2 = 0; i2 < x; i2++) {
            {
                printWriter.print(isString + Array.get(method.invoke(o), i2) + isString);
                if (i2 < x - 1) {
                    printWriter.println(",");
                } else {
                    printWriter.println("");
                }
            }
        }
        printWriter.println("]");

    }

    private static void nowyObiekt(PrintWriter printWriter, Method[] methods, int i, Object innerObject) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        Class clazzz;
        if (innerObject != null) {
            System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm nowy obiekt");
            clazzz = methods[i].getReturnType();
            nowyObiekt(printWriter, clazzz, innerObject);
            System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm koniec nowego obiektu");

        } else {
            printWriter.print("null");
        }
    }

    private static Method[] getMethods(Class clazzz, Field[] fields) throws NoSuchMethodException {
        Method[] methods = new Method[fields.length];
        for (int i = 0; i < methods.length; i++) {
            String fieldName = fields[i].getName();
            String s1 = fieldName.substring(0, 1).toUpperCase();
            String nameCapitalized = s1 + fieldName.substring(1);
            String methodName = "get" + nameCapitalized;
            methods[i] = clazzz.getMethod(methodName);
        }
        return methods;
    }

    private static List<String> listaZTypami() {
        List<String> typesList = new ArrayList<>();
        typesList.add("int");
        typesList.add("boolean");
        typesList.add("float");
        typesList.add("String");
        typesList.add("double");
        typesList.add("int[]");
        typesList.add("String[]");
        typesList.add("float[]");
        typesList.add("double[]");
        typesList.add("boolean[]");
        typesList.add("List");
        return typesList;
    }

}
