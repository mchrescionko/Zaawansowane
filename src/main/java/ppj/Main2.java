package ppj;

public class Main2 {

    public static void main(String[] args) {
        int i=4;
        float f= 4.4f;
        char c = 'r';
        boolean b = true;


        long fc = 5;
        float fr = 5;
        System.out.println(fr);
        System.out.println(fc);



        //kolejka, stos, lista itd
        //trzy rodzaje sortowania


    }
    void sort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
