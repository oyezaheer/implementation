import java.util.Arrays;



// BSI -> bubble, selection, insertion 
// best -> insertion > bubble > selection || 
// space complexity -> O(1)

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {4,31,5,15,2};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertion(int arr[]) {
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j>0; j--) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    static void selection(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            int last = arr.length-i-1;
            int maxInd = getMaxInd(arr, 0, last);
            swap(arr,maxInd, last );
        }
    }
    static void swap(int arr[] , int first, int second) {
        int temp = arr[first];
        arr[first] =  arr[second];
        arr[second] = temp;
    }

    static int getMaxInd(int[] arr, int start, int end) {
        int max = start;
        for(int i = start; i<=end; i++) {
            if(arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
    static void bubble(int[] arr){
        boolean swapped;
        for(int i=0; i<arr.length; i++) {
            swapped = false;
            for(int j=1; j<arr.length-i; j++) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}