package refleksja;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        MyObject myObject = new MyObject();
        Class<MyObject> class1 = MyObject.class;
        Class class2 = myObject.getClass();
        Class class3 = Class.forName("refleksja.MyObject");

        System.out.println(class3.getName());
        int modifier = class3.getModifiers();
        System.out.println(Modifier.toString(modifier));
        System.out.println(modifier);

        Class[] interfejsy  = class3.getInterfaces();
        System.out.println(Arrays.toString(interfejsy));
        boolean found = false;

        for (Class aClass : interfejsy) {
            if (aClass.getName().equals("java.io.Serializable")) {
                found = true;
            }
        }
        if (found) {
            System.out.println("Znaleziono");
        } else {
            System.out.println("nie ma");
        }

        System.out.println("/////////////");

        Field[] fields = class1.getFields();
        System.out.println("field1: "+fields[0]);

        Method[] methods = class1.getMethods();
        for (Method method : methods) {
            if(method.getName().equals("sayHello"))
            System.out.println(method.getReturnType() + " " + method.getName() + " "+ Arrays.toString(method.getParameters()));
        }

        Method method = class1.getDeclaredMethod("sayHello");
        Method method2 = class1.getMethod("sayHello", String.class);
        Method method3 = class1.getMethod("sayHello", String[].class);

        method.setAccessible(true);
        method.invoke(myObject);
        method2.invoke(myObject, "pierwszyString");
        String result = (String) method3.invoke(myObject, (Object) new String []{"pierwszy", "drugi"});

        Constructor constructor = class1.getConstructor();
        Constructor<MyObject> constructor2 = class1.getConstructor(String.class, int.class, MyObject2.class);
        Constructor constructor3 = class1.getConstructor(String.class, int.class);

        MyObject myObject2 = (MyObject) constructor.newInstance();
        System.out.println(myObject2);

        MyObject myObject3 = constructor2.newInstance("StringJakis", 5, new MyObject2());
        System.out.println(myObject3);

        Field field = class1.getDeclaredField("name");
        Field field2 = class1.getDeclaredField("myNumber");

        field.setAccessible(true);
        field2.setAccessible(true);

        System.out.println(field.get(myObject3));
        System.out.println(field2.get(myObject3));

        field2.set(myObject3, 6);

        System.out.println(myObject3);

        MyAnnotation annotation = (MyAnnotation) class3.getAnnotation(MyAnnotation.class);

        System.out.println(annotation.name());
    }
}
