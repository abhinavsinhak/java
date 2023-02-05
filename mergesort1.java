import java.util.*;
public class mergesort1 {
    public static void mergesort(int arr[], int l, int r) {
        if (l < r) {
            int mid = l + r/ 2;

            mergesort(arr, l, mid);
            mergesort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int arr[], int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int a[] = new int[n1];
        int b[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            a[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            b[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                arr[k] = a[i];
                k++;
                i++;

            } else {
                arr[k] = b[j];
                k++;
                j++;
            }
        }
        while (i < n1) {
            arr[k] = a[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k] = b[j];
            k++;
            j++;
        }

    }
    public static void main(String[] args) {
        int n; 
        Scanner scr = new Scanner(System.in);
        System.out.println("enter the no of element");
        n = scr.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the elements");
        for(int i=0;i<n;i++){
            arr[i] = scr.nextInt();
        }
        
        mergesort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}
