import java.util.Arrays;

public interface selectionsort {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 3, 6, 5 };
        int n = arr.length;
        int indx = 0;
            int temp = 0;
        for (int i = 0; i < n; i++) {
            
            int a = arr[i];
            for (int j = i; j < n; j++) {
                if (arr[j] >= a) {
                    a = arr[j];
                    indx = j;
                }
               
            }

            temp = arr[i];
            arr[i] = arr[indx];
            arr[indx] = temp;
        }
        System.out.println(Arrays.toString(arr));

    }

}