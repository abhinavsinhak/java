import java.util.*;

public class sort012 {

    public static void main(String[] args) {
        int arr[] = new int[5];
        int n, temp;
        Scanner scr = new Scanner(System.in);
        System.out.println("enter the value of n");
        n = scr.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = scr.nextInt();
        }
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;

            }
        }
        System.out.println("\n\n");
        System.out.println(Arrays.toString(arr));

    }

}