package wzorceProjektowe.behavioral.state;

public class OneHandBandit {
     State state = new NoCoinState();

    public void setState(State state) {
        this.state = state;
    }

    public void insertCoin() {
        state.insertCoin(this);

    }

    public void pullLever() {
        state.pullLever(this);
    }

    public void takePrice() {
        state.takePrice(this);
    }

    public void showTheState() {
        state.showTheState(this);
    }
}
