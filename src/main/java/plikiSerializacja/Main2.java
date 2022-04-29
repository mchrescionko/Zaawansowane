package plikiSerializacja;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MyObject2 myObject2 = new MyObject2(4, "name2");
        MyObject myObject = new MyObject("name", 4, myObject2);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("MyPlik.bin"));
        objectOutputStream.writeObject(myObject);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("MyPlik.bin"));
        MyObject myObject1 = (MyObject) objectInputStream.readObject();
        System.out.println(myObject1);

        System.out.println(myObject==myObject1);
        System.out.println(myObject.equals(myObject1));

    }
}
