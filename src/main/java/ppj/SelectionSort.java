package ppj;

public class SelectionSort {
    public static void main(String[] args) {


        int [] tab = {2,3,4,1};
        sort(tab);

        for (int i : tab) {
            System.out.println(i);
        }
    }
    public static void sort(int [] tab){
        for(int i=0;i<tab.length-1;i++){
            int minX = i;
            for(int j=i+1;j<tab.length;j++){
                if(tab[j]<tab[minX]){
                    minX=j;
                }
            }
            int temp = tab[minX];
            tab[minX]=tab[i];
            tab[i]=temp;
        }
    }
}
