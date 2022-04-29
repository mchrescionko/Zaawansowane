package ppj;

public class InsertionSort {
    public static void main(String[] args) {

        int [] tab = {2,3,4,1};
        sort(tab);
        for (int i : tab) {
            System.out.println(i);
        }

    }
    public static void sort(int[] tab){
        for(int i=1;i<tab.length;i++){
            int key = tab[i];
            int j=i-1;
            while((j>-1)&&(tab[j]>key)){
                tab[j+1] = tab[j];
                j--;
            }
            tab[j+1]=key;
        }
    }
}
