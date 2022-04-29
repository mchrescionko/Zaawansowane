package wzorceProjektowe.behavioral.state;

public class NoCoinState implements State{

    @Override
    public void insertCoin(OneHandBandit oneHandBandit) {
        System.out.println("wrzuciles monete");
        oneHandBandit.setState(new InsertedCoinState());
    }

    @Override
    public void pullLever(OneHandBandit oneHandBandit) {
        System.out.println("wrzuc monete");
    }

    @Override
    public void takePrice(OneHandBandit oneHandBandit) {
        System.out.println("wrzuc monete");
    }

    @Override
    public void showTheState(OneHandBandit oneHandBandit) {
        System.out.println("wrzuc monete");
    }
}
