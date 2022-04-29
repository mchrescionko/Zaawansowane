package enumy;

import javax.swing.*;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        Drogowskaz drogowskaz = new Drogowskaz(Strona.POLNOC);
        Drogowskaz drogowskaz2 = new Drogowskaz(Strona.WSCHOD);

        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);

        jFrame.setSize(1000,1000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println(drogowskaz2.getStrona().getDegrees());
        System.out.println(Arrays.toString(Strona.values()));

        for(Strona strona:Strona.values()){
            if(strona.getDegrees()>90)
            System.out.println(strona);
        }

        Strona strona = Strona.valueOf("POLUDNIE");
        switch (strona){
            case POLNOC :
                System.out.println(strona.getDegrees());
                break;
            case POLUDNIE :
                System.out.println(strona.getDegrees());
                break;
            case WSCHOD :
                System.out.println(strona.getDegrees());
                break;
            case ZACHOD :
                System.out.println(strona.getDegrees());
                break;

        }
        System.out.println(strona.ordinal());
        System.out.println(strona.name());
    }
}
