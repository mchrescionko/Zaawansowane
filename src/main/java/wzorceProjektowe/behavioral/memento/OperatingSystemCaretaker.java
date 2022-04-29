package wzorceProjektowe.behavioral.memento;

public class OperatingSystemCaretaker {

    private OperatingSystemMemento backup;

    public void addMemento(OperatingSystemMemento operatingSystemMemento){
        backup = operatingSystemMemento;
        System.out.println("zapisany backup: "+operatingSystemMemento.getBackUpNumber());
    }

    public OperatingSystemMemento getBackup(int index){
        System.out.println("wczytano backup "+backup.getBackUpNumber());
        return backup;
    }

    public OperatingSystemMemento getMemento() {
        return backup;
    }
}
