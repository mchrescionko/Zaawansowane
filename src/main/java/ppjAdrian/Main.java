package ppjAdrian;

public class Main {
    public static void main(String[] args) {
        Gear gear0 = new Gear(1231);
        Gear gear1 = new Gear(1232);

        Machine machine1 = new Machine(new Gear[]{gear0, null});
        machine1.show();

        machine1.isMachineComplete();
        machine1.add(gear1);
        machine1.isMachineComplete();

        Gear gear3 = new Gear(1234);
        try {
            machine1.add(gear3);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        Gear gear4 = new Gear(1235);
        try {
            //pierwsza tablica char to elementy z ktorych nalezy zamienic
            //druga tablica char elementy ktore trzeba zamienic
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

        Machine[] machines = {
                machine1,
                machine2
        };
        for (Machine machine: machines){
            System.out.println("***********************");
            machine.show();
        }
        String msg = "let pass";
        System.out.println("Out: " + machine2.encryptMessage(msg));
    }
}
