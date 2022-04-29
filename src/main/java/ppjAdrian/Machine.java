package ppjAdrian;

public class Machine {
    protected Gear[] gears;

    public Machine(Gear[] gears) {
        this.gears = gears;
        int count = 0;
        for (int i = 0; i < gears.length; i++) {
            if (gears[i] != null) {
                count++;
            }
        }
        System.out.println("Creating machine with " + count + " gear of " + gears.length);

    }

    public Machine(int number) {
        this.gears = new Gear[number];
    }

    public void add(Gear gear) {
        for (int i = 0; i < gears.length; i++) {
            if (gears[i] == null) {
                gears[i] = gear;
            }
        }
    }

    public void isMachineComplete() {
        int checker = 0;
        for (int i = 0; i < gears.length; i++) {
            if (gears[i] == null) {
                checker = 0;
                break;
            } else {
                checker = 1;
            }
        }
        if (checker == 1) {
            System.out.println("Machine is complete");
        } else {
            System.out.println("Machine is incomplete");
        }
    }

    public void show() {
        System.out.println("Machine parts:");
        for (int i = 0; i < gears.length; i++) {
            if (gears[i] != null) {
                System.out.println("Gear number: " + gears[i].getNumber());
            } else {
                System.out.println("Gear number: " + gears[i]);
            }
        }
    }
}

class Enigma extends Machine {
    public Enigma(int number) {
        super(number);
        System.out.println("This is an Enigma machine");
    }

    public String encryptMessage(String msg) {
        return msg;
    }

    @Override
    public void add(Gear gear) {
        super.add(gear);
    }

    @Override
    public void show() {
        System.out.println("This machine is secret cant show it gears");
    }

    @Override
    public void isMachineComplete() {
        super.isMachineComplete();
    }
}
