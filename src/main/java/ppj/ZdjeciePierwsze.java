package ppj;

public class ZdjeciePierwsze {
    public static void main(String[] args) {

        int [][] tab = new int [9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                tab[i][j] = i;
                System.out.print(i);
            }
            System.out.println();
        }
        int [] result = metoda(tab);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public static int[] metoda(int[][] slowo) {
        int suma = 0;
        for (int i = 0; i < slowo.length; i++) {
            for (int j = 0; j < slowo[i].length; j++) {
                suma = suma + slowo[i][j];
            }
        }
        int[] tablica = new int[slowo.length];

        if (suma % 2 == 0) {
            for (int i = 0; i < slowo.length; i++) {
                tablica[i] = slowo[i][i];
            }
            return tablica;
        } else {
            int srodek;
            int srodek2;
            if(slowo.length%2==0){

                srodek = (int) (slowo.length/2);
                srodek2 = srodek+1;

                for (int i = 0; i < slowo.length; i++) {
                    tablica[i] = (int)(slowo[i][srodek]/2+slowo[i][srodek2]/2);
                }

                return tablica;
            }else{
                for (int i = 0; i < slowo.length; i++) {
                    tablica[i] = slowo[slowo.length/2][i];
                }

                return tablica;
            }
        }
    }
}
