// Java program to find
// duplicates in the given array
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class findduplicate1 {
    // Driver program
    public static void main(String[] args) {
        int arr[] = { 12, 11, 40, 12, 5, 6, 5, 12, 11 };
        int n = arr.length;
        printDuplicates(arr, n);
    }

    // function to find and print duplicates
    private static void printDuplicates(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        boolean dup = false;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            // if frequency is more than 1
            // print the element
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
                dup = true;
            }
        }
        // no duplicates present
        if (!dup) {
            System.out.println("-1");
        }
    }
}
