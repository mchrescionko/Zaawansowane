package ppjAdrian;

public class Gear {

    private int number;

    public int getNumber() {
        return number;
    }

    public Gear(int number) {
        this.number = number;
    }

    public void engraveCode(char[] chars, char[] chars1) {
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars1[i];
        }
        System.out.println("Gear " + number + " engraving complete");
    }
}
