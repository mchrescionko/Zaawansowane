package wzorceProjektowe.behavioral.state;

public interface State {


    void insertCoin(OneHandBandit oneHandBandit);
    void pullLever(OneHandBandit oneHandBandit);
    void takePrice(OneHandBandit oneHandBandit);
    void showTheState(OneHandBandit oneHandBandit);

}
