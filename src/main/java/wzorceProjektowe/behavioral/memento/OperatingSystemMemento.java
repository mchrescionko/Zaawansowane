package wzorceProjektowe.behavioral.memento;

import java.util.Date;

public class OperatingSystemMemento {
    private final int backUpNumber;
    private final Date date;


    public Date getDate() {
        return date;
    }

    public OperatingSystemMemento(int backUpNumber, Date date) {
        this.backUpNumber = backUpNumber;
        this.date = date;
    }

    public int getBackUpNumber() {
        return backUpNumber;
    }


}
