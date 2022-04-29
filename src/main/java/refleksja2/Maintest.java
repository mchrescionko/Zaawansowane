package refleksja2;

import lombok.Data;
import wzorceProjektowe.constructive.factory.abstractFactory.MechanizedUnit;

import javax.persistence.OneToMany;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Maintest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int [] x = new int [3];
        System.out.println();
        Class<ClassTest> class1 = ClassTest.class;
        Method method = class1.getMethod("getTab");
        Method methodInt = class1.getMethod("getNumber");
        Method methodListInt = class1.getMethod("getIntList");
        Method methodget = class1.getMethod("getClassTest");
        String typ = method.getReturnType().getSimpleName();
        String typint = methodInt.getReturnType().getSimpleName();
        String typListint = methodListInt.getReturnType().getSimpleName();
        System.out.println("typ: "+typ);
        System.out.println("nazwa: "+method.getName());
        System.out.println("typ2: "+typint);
        System.out.println("nazwa: "+methodInt.getName());
        System.out.println("typListInt: "+typListint);
        System.out.println("nazwa: "+methodListInt.getName());

        int [] tab = new int [3];
        tab[0]=10;
        tab[1]=20;
        tab[2]=30;
        for (int i : tab) {
            System.out.println(i);
        }

        ClassTest classTest1= new ClassTest();

        ClassTest classTest = new ClassTest(4, classTest1);

        Object object2 = methodget.invoke(classTest);
        System.out.println(object2);



    }
}
@Data
class ClassTest{
    int [] tab;
    int number;
    List<Integer> intList;
    ClassTest classTest;

    public ClassTest() {
    }

    public ClassTest(int number, ClassTest classTest) {
        this.number = number;
        this.classTest = classTest;
    }

    public ClassTest getClassTest() {
        return classTest;
    }

    public ClassTest(int[] tab) {
        this.tab = tab;
    }

    public List<Integer> getIntList() {
        return intList;
    }

    public int getNumber() {
        return number;
    }

    public int[] getTab() {
        return tab;
    }

    public static void main(String[] args) {




    }
}

