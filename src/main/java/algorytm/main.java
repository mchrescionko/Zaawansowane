package algorytm;

import graf.Main;

public class main {
    public static void main(String[] args) {

//        int [] wybory = {0,0,0,0,0,0,0,1,1,1};

        int [][] tablica = new int [15][15];
        for(int y=0;y< tablica.length;y++){
            for(int x=0;x<tablica[y].length;x++){
                tablica[y][x]=0;
            }
        }
        int x;
        int y;
        boolean result=true;

        for(int i=0;i<60;i++){
            result=true;
            while(result){
                x=(int)(Math.random()*15);
                y=(int)(Math.random()*15);
                if(tablica[x][y]==0){
                    result=false;
                    tablica[x][y]=1;
                }
            }
        }
        result=true;
        int x2;
        int x3;
        int y2;
        int y3;
        while(result){
            x=(int)(Math.random()*15);
            y=(int)(Math.random()*15);
            if(tablica[x][y]==0){
                result=false;
                tablica[x][y]=2;
                x2=x;
                y2=y;

            }
        }


        result=true;
        while(result){
            x=(int)(Math.random()*15);
            y=(int)(Math.random()*15);
            if(tablica[x][y]==0){
                result=false;
                tablica[x][y]=3;
                x3=x;
                y3=y;
            }
        }
        for(y=0;y< tablica.length;y++) {
            for (x = 0; x < tablica[y].length; x++) {
                System.out.print(tablica[y][x]);
            }
            System.out.println();
        }



    }

//    public static void droga( int [][]tablica, int y2,int y3, int x2, int x3){
//        if(y2<y3){
//            if(tablica[y2+1][x2]==0){
//                droga(tablica, y2+1, y3, x2,x3);
//            }
//        }else if(y2==y3){
//
//        }
//    }
}
