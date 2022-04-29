package algorytm.kalkulatorCzasowy;

import java.time.LocalDate;

public class Main2 {

    public static void ktoryDzien(){
        LocalDate data1996 = LocalDate.of(2025, 10, 24);
        LocalDate dataTeraz = LocalDate.now();
        int liczbaDni=0;
        while(!dataTeraz.equals(data1996)){
            data1996 = data1996.minusDays(1L);
            liczbaDni++;
            System.out.println(liczbaDni);
        }
        System.out.println(liczbaDni%7);
        String dzien = "";
        if(liczbaDni%7==0){
            dzien = "sroda";
        }else if(liczbaDni%7==6){
            dzien = "wtorek";
        }else if(liczbaDni%7==5){
            dzien = "poniedziałek";
        }else if(liczbaDni%7==4){
            dzien = "niedziela";
        }else if(liczbaDni%7==3){
            dzien = "sobota";
        }else if(liczbaDni%7==2){
            dzien = "piatek";
        }else if(liczbaDni%7==1) {
            dzien = "czwartek";
        }

        System.out.println("tego dnia była " + dzien);
    }
    public static void main(String[] args) {

        ktoryDzien();
    }
}
