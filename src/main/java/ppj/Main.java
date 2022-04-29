package ppj;

import net.bytebuddy.implementation.bytecode.Throw;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Mac;

public class Main {
    public static void main(String[] args) {
        Gear gear0 = new Gear(1231);
        Gear gear1 = new Gear(1232);
        Machine machine1 = new Machine(
                new Gear[]{gear0, null}
        );
        machine1.show();
        machine1.isMachineComplete();
        machine1.add(gear0);
        machine1.isMachineComplete();

        Gear gear3 = new Gear(1234);

        try {
            machine1.add(gear3);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        Gear gear4 = new Gear(1235);
        try {
            gear3.engraveCode(
                    new char[]{'l', 't', 'c'},
                    new char[]{'o', '_', 'f'}
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gear4.engraveCode(
                    new char[]{'c', 'z', 'b', 'g'},
                    new char[]{'r', 'v', 'g'}
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gear4.engraveCode(
                    new char[]{'e', 's', 'b'},
                    new char[]{'k', 'b', 'g'}
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        Enigma machine2 = new Enigma(2);
        machine2.add(gear3);
        machine2.add(gear4);

        Machine[]  machines = {
                machine1,
                machine2
        };

        for(Machine machine: machines){
            System.out.println("**************");
            machine.show();
        }

        String msg = "lets pass";
        System.out.print(
                "Out: "
        );
        machine2.encryptMessage(msg);
    }

    static class Gear {
        int liczba;
        char[] firstTab;
        char[] secondTab;

        public Gear(int liczba) {
            this.liczba = liczba;
        }

        public void engraveCode(char[] firstTab, char[] secondTab) throws Exception {
            if (firstTab.length != secondTab.length) {
                throw new Exception("Wrong length");
            } else {
                this.firstTab = firstTab;
                this.secondTab = secondTab;

                System.out.println("Gear " + getLiczba() + " engraving complete");

            }
        }

        public int getLiczba() {
            return liczba;
        }

        @Override
        public String toString() {
            return "Gear number: " + liczba;
        }
    }

    static class Machine {
        Gear[] tablicaGear;

        public Machine() {
        }

        public Machine(Gear[] tablicaGear) {
            this.tablicaGear = tablicaGear;
            if (tablicaGear[0] == null) {
                System.out.println("Creating machine with 0 gear of 2");
            } else if (tablicaGear[1] == null) {
                System.out.println("Creating machine with 1 gear of 2");
            }
        }

        public void encryptMessage(String text){
            char[] chars = text.toCharArray();
            int x=0;
            for (char aChar : chars) {
                x=0;
                for(int i=0;i<tablicaGear[0].firstTab.length;i++){
                    if(aChar==tablicaGear[0].firstTab[i]){
                        System.out.print(tablicaGear[0].secondTab[i]);
                        x=1;
                        break;
                    }else if (aChar==tablicaGear[1].firstTab[i]){
                        System.out.print(tablicaGear[1].secondTab[i]);
                        x=1;
                        break;
                    }
                }
                if(x==0){
                    System.out.print(aChar);
                }

            }
        }

        public void show() {
            System.out.println("Machine parts:");
            for (Gear gear : tablicaGear) {
                System.out.println("\t" + gear);
            }
        }

        public void isMachineComplete() {
            if (tablicaGear[1] != null) {
                System.out.println("This machine is complete");
            } else {
                System.out.println("This machine is not complete");
            }
        }

        public void add(Gear gear) {
            if (tablicaGear[0] == null) {
                tablicaGear[0] = gear;
            } else if (tablicaGear[1] == null) {
                tablicaGear[1] = gear;
            }
        }

    }

    static class Enigma extends Machine {
        int number;

        public Enigma(int x) {
            super(new Gear[2]);
            this.number = x;

            System.out.println("this is an Enigma machine");
        }

        @Override
        public void add(Gear gear) {
            super.add(gear);
            isMachineComplete();
        }

        @Override
        public void show() {
            System.out.println("This machine is secret ,cant show its gears");
        }
    }
}
