package zadaniaRekrturacyjne;

import java.util.Arrays;

public class BinSearch2 {
    boolean result;
    public BinSearch2(){
        result = true;
    }
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }


    public static void main(String[] args) {
        BinSearch2 ob = new BinSearch2();
        int arr[] = { 2, 3, 4, 10, 40 };
        arr = Arrays.stream(arr).sorted().toArray();
        int n = arr.length;
        int x = 10;
        boolean result = true;
        while(result){

        }
//        int result = ob.binarySearch(arr, 0, n - 1, x);
    }
}
