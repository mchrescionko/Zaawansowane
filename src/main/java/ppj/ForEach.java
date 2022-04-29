package ppj;

public class ForEach  {
    public static void main(String[] args) {
//        int [] tab = {1,2,3};
//        for (int i : tab) {
//            i=i+3;
//        }
//        for (int i : tab) {
//            System.out.println(i);
//        }
        int x = 0b101;
        System.out.println(x);
        System.out.println(~0b101);
        System.out.println(-0b101);
        System.out.println(0b010);
        System.out.println(-0b010);
//
//        System.out.println(0b01&0b01);
//        System.out.println(0b11|0b01);
//        System.out.println(0b0011|0b110);

        System.out.println(0b0001);
        System.out.println(0b0001<<2);
        System.out.println(0b0001<<2+0b1);
        System.out.println((0b0001<<2)+0b1);

        int g=10000;
        byte f = (byte) g;
        System.out.println("f: "+f);

        int i=0;
        do{
            System.out.println(i);
            i++;
        }while (i<10);


    }

    public static void p(){
        
    }
}
