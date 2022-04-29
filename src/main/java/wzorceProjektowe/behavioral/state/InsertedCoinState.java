package wzorceProjektowe.behavioral.state;

public class InsertedCoinState implements State{


    @Override
    public void insertCoin(OneHandBandit oneHandBandit) {
        System.out.println("moneta jest juz w maszynie, pociagnij dzwignie");
    }

    @Override
    public void pullLever(OneHandBandit oneHandBandit) {
        System.out.println("pociagnieto dzwignie");
        if(Math.random()<0.2){
            oneHandBandit.setState(new WinState());
            System.out.println("brawo, wygrałeś!");
        }else{
            oneHandBandit.setState(new NoCoinState());
            System.out.println("niestety, nie wygrales");
        }

    }

    @Override
    public void takePrice(OneHandBandit oneHandBandit) {
        System.out.println("pociagnij dzwignie");
    }

    @Override
    public void showTheState(OneHandBandit oneHandBandit) {
        System.out.println("pociagnij dzwignie");
    }
}
