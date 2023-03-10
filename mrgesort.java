import java.util.Arrays;

public class mrgesort {
    public static void divide(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            divide(arr, l, mid);
            divide(arr, mid + 1, r);
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
        for (int i = 0; i < n2; i++) {
            b[i] = arr[mid + 1 + i];
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
        while (j < n2) {
            arr[k] = b[j];
            k++;
            j++;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        divide(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }

}
