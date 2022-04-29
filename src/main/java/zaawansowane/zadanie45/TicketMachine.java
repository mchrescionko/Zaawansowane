package zaawansowane.zadanie45;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TicketMachine {

    private String cecha;
    private double cena;
    private int papier;

    public TicketMachine(String cecha, double cena, int papier) {
        this.cecha = cecha;
        this.cena = cena;
        this.papier = papier;
    }

    public TicketMachine(double cena, int papier) {
        this.cecha = "C";
        this.cena = cena;
        this.papier = papier;
    }

    public String getCecha() {
        return cecha;
    }

    public double getCena() {
        return cena;
    }

    public int getPapier() {
        return papier;
    }

    public int howManyTickets (){
        int result = (int)papier/4;
        return result;
    }
    public void changePaper(int papier){
        this.papier = papier;
    }
    public void changeArea(String area){
        if(area.equals("A")||area.equals("B")||area.equals("C")){
            this.cecha = area;
        }

    }
    public boolean isActive(LocalDateTime date){
        if((date.getDayOfWeek().equals(DayOfWeek.MONDAY)||date.getDayOfWeek().equals(DayOfWeek.TUESDAY)||date.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)||date.getDayOfWeek().equals(DayOfWeek.THURSDAY)||date.getDayOfWeek().equals(DayOfWeek.FRIDAY))&&
                (date.getHour()>=8&&date.getHour()<=20)){
            return true;
        }
        return false;
    }


}
