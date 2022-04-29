package ppj;

public class TrueJesliLiczba {

    int liczba1;
    String slowo1;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {

        int tab[] = {};
        char[] tablica = new char []{'f'};

        int [][] x = {{}};

        Object objTab[] = new String[5];

        String strTab[] = null;

        boolean result = metoda(tablica);
        System.out.println(result);
    }
    public static boolean metoda(char[] slowo){
        int length = slowo.length;
        int x;
        for(int i=0;i<length;i++){
            if((int)slowo[i]<57&&(int)slowo[i]>48){
                return true;
            }
        }
        return false;
    }
}
