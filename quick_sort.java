import java.io.*;
import java.util.Arrays;

public class quick_sort {
  public static int divide(int arr[], int low, int high) {
    int piv = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (arr[j] <= piv) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return (i + 1);
  }

  public static void quicksort(int arr[], int low, int high) {
    if (low < high) {
      int pi = divide(arr, low, high);
      quicksort(arr, low, pi - 1);
      quicksort(arr, pi + 1, high);
    }
  }

  public static void main(String[] args) {
    int arr[] = { 2, 5, 2, 6, 2, 4 };
    System.out.println(Arrays.toString(arr));
    quicksort(arr, 0, 5);
    System.out.println(Arrays.toString(arr));
  }
}
