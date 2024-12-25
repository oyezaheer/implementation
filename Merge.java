import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int arr[] = { 2, 24, 223, 51, 5 };
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void quick(int arr[], int low, int hi) {
        if(low >= hi) {
            return;
        }
        int s = low;
        int e = hi;
        int m = s + (e-s)/2;
        int pivot = arr[m];
        while(s <= e) {
            while(arr[e] >pivot) {
                
            }
        }

    }

    static int[] mergeSort(int arr[]) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    static int[] merge(int[] first, int second[]) {
        int mix[] = new int[first.length + second.length];
        int i = 0;
        int j= 0;
        int k = 0;
        while(i < first.length && j < second.length) {
            if(first[i] <= second[j]){
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while(i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}