package wzorceProjektowe.behavioral.state;

public class WinState implements State{
    @Override
    public void insertCoin(OneHandBandit oneHandBandit) {
        System.out.println("odbierz nagrode");
    }

    @Override
    public void pullLever(OneHandBandit oneHandBandit) {
        System.out.println("odbierz nagrode");
    }

    @Override
    public void takePrice(OneHandBandit oneHandBandit) {
        System.out.println("wygrana odebrana");
        oneHandBandit.setState(new NoCoinState());
    }

    @Override
    public void showTheState(OneHandBandit oneHandBandit) {
        System.out.println("stan wygrana");
    }
}
