package lombock;

public class Main {
    public static void main(String[] args) {

        MyObject myObject = new MyObject();
        MyObject myObject2 = new MyObject(1,2,"first");

        System.out.println(myObject);
        myObject.setFirstInt(4);
        System.out.println(myObject);

    }
}
