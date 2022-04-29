package wzorceProjektowe.behavioral.memento;

import java.util.Date;

public class OperatingSystem {
    private int backupNumber;
    private Date backupDate;

    public void createBackup() {
        this.backupNumber++;
        this.backupDate = new Date();
        System.out.println("Utworzono backup nr: " + this.backupNumber + " z datą: " + backupDate);
    }

    public Date getBackupDate() {
        return backupDate;
    }

    public OperatingSystemMemento save(){
        return new OperatingSystemMemento(this.backupNumber, this.backupDate);


    }

    public void load(OperatingSystemMemento operatingSystemMemento){
        System.out.println("wczytano backup nr "+operatingSystemMemento.getBackUpNumber() +" z datą "+ operatingSystemMemento.getDate() );
        backupNumber = operatingSystemMemento.getBackUpNumber();
        this.backupNumber = operatingSystemMemento.getBackUpNumber();
    }
}
