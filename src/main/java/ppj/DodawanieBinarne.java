package ppj;

public class DodawanieBinarne {
    public static void main(String[] args) {
        int x = 2;
        int y = 1;

        y = x++ ;
        System.out.println(y);
        System.out.println(x);

        x = 2;
        y = 1;

        y = x++ + y + --x;
        System.out.println(y);
        System.out.println(x);

        x=0;
        y=0;
        int z=0;

        z = x++ + ++x + ++y;

        x=0;
        y=0;
        z=0;



        System.out.println("x = "+x);
        System.out.println("y = "+y);
        System.out.println("z = "+z);

        int q = 0b11;
        int q1 = 0x10;
        int q2 = 077;


        System.out.println("q ="+q);
        System.out.println("q1 ="+q1);
        System.out.println("q2 ="+q2);



    }
}
