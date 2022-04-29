package wzorceProjektowe.behavioral.state;

public class Main {
    public static void main(String[] args) {
        OneHandBandit oneHandBandit = new OneHandBandit();
        oneHandBandit.insertCoin();
        oneHandBandit.insertCoin();
        oneHandBandit.pullLever();
        oneHandBandit.pullLever();

        oneHandBandit.takePrice();
        oneHandBandit.takePrice();

    }
}
