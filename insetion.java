import java.util.*;

public class insetion {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 3, 6, 5 };
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = 1, key = 1;
            int temp;
            while (j >= 0 && arr[j] < arr[j - 1]) {
                temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
            key++;
            j = key + 1;
        }
        System.out.println(Arrays.toString(arr));

    }
}
