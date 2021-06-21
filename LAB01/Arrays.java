import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* Linear Arrays */
        // 1
        int[] arr = {10, 20, 30, 40, 50, 60};
        shiftLeft(arr, 3);
        print(arr);
        // 2
        arr = new int[]{10, 20, 30, 40, 50, 60};
        rotateLeft(arr, 3);
        print(arr);
        // 3
        arr = new int[]{10, 20, 30, 40, 50, 0, 0};
        remove(arr, 5, 2);
        print(arr);
        // 4
        arr = new int[]{10, 2, 30, 2, 50, 2, 2, 0, 0};
        removeAll(arr, 7, 2);
        print(arr);
        // 5
        int[] arr1 = {1, 1, 1, 2, 1};
        int[] arr2 = {12, 1, 1, 2, 1};
        int[] arr3 = {10, 3, 1, 2, 10};
        System.out.println(splitArray(arr1));
        System.out.println(splitArray(arr2));
        System.out.println(splitArray(arr3));
        // 6
        int n1 = 2, n2 = 3, n3 = 4;
        arr1 = arraySeries(n1);
        arr2 = arraySeries(n2);
        arr3 = arraySeries(n3);
        print(arr1);
        print(arr2);
        print(arr3);
        // 7
        arr1 = new int[]{1, 2, 2, 3, 4, 4, 4};
        arr2 = new int[]{1, 1, 2, 2, 1, 1, 1, 1};
        System.out.println(maxBunchCount(arr1));
        System.out.println(maxBunchCount(arr2));
        // 8
        arr1 = new int[]{4, 5, 6, 6, 4, 3, 6, 4};
        arr2 = new int[]{3, 4, 6, 3, 4, 7, 4, 6, 8, 6, 6};
        System.out.println(repetition(arr1));
        System.out.println(repetition(arr2));
        /* Circular Arrays */
        // 1
        arr1 = new int[]{20, 10, 0, 0, 0, 10, 20, 30};
        arr2 = new int[]{10, 20, 0, 0, 0, 10, 20, 30};
        System.out.println(palindrome(arr1, 5, 5));
        System.out.println(palindrome(arr2, 5, 5));
        // 2
        arr1 = new int[]{40, 50, 0, 0, 0, 10, 20, 30};
        arr2 = new int[]{10, 20, 5, 0, 0, 0, 0, 0, 5, 40, 15, 25};
        int[] commonElements = intersection(arr1, 5, 5, arr2, 8, 7);
        print(commonElements);
        // 3

    }

    /* Helper Methods */
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /* Linear Arrays */

    // Problem 01 - Shift Left k Cells
    public static void shiftLeft(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - k) {
                arr[i] = arr[i + k];
            } else {
                arr[i] = 0;
            }
        }
    }

    // Problem 02 - Rotate Left k Cells
    public static void rotateLeft(int[] arr, int k) {
        for (int i = 0; i < arr.length - k; i++) {
            swap(arr, i, i + k);
        }
    }

    // Problem 03 - Remove an element from an array
    public static void remove(int[] arr, int size, int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = 0;
    }

    // Problem 04 - Remove all occurrences of a particular element from an array
    public static void removeAll(int arr[], int size, int element) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                counter++;
                arr[i] = 0;
            }
        }
        size -= counter;
        int l = 0, r = 0;
        while (l < size) {
            if (arr[l] == 0) {
                r = l + 1;
                while (arr[r] == 0) {
                    r++;
                }
                swap(arr, l, r);
                l = r - 1;
            }
            l++;
        }
    }

    // Problem 05 - Splitting an Array
    public static boolean splitArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int partialSum = 0;
        for (int i = 0; i < arr.length; i++) {
            partialSum += arr[i];
            if (partialSum * 2 == sum) {
                return true;
            }
            if (partialSum * 2 > sum) {
                return false;
            }
        }
        return false;
    }

    // Problem 06 - Array series
    public static int[] arraySeries(int n) {
        int[] result = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (n - j - 1 >= i) {
                    result[i * n + j] = j + 1;
                } else {
                    result[i * n + j] = 0;
                }
            }
        }
        int l = 0, r = result.length - 1;
        while (l < r) {
            swap(result, l, r);
            l++;
            r--;
        }
        return result;
    }

    // Problem 07 - Max Bunch Count
    public static int maxBunchCount(int[] arr) {
        if (arr.length == 0) return 0;
        int current = 1, best = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                current++;
            } else {
                current = 1;
            }
            best = Math.max(current, best);
        }
        return best;
    }

    // Problem 08 - Repetition
    public static boolean repetition(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int i : arr) {
            if (freq.get(i) != null) {
                freq.put(i, freq.get(i) + 1);
            } else {
                freq.put(i, 1);
            }
        }
        HashSet<Integer> s = new HashSet<Integer>();
        for (int value : freq.values()) {
            if (value == 1) continue;
            if (s.contains(value)) {
                return true;
            }
            s.add(value);
        }
        return false;
    }

    /* Circular Arrays */

    // Problem 01 - Palindrome
    public static boolean palindrome(int[] arr, int start, int size) {
        ArrayList<Integer> store = new ArrayList<Integer>();
        for (int i = start; i < arr.length; i++) {
            store.add(arr[i]);
        }
        for (int i = 0; arr[i] != 0; i++) {
            store.add(arr[i]);
        }
        int l = 0, r = store.size() - 1;
        while (l < r) {
            if (store.get(l) != store.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // Problem 02 - Intersection
    public static int[] intersection(int[] arr1, int start1, int size1, int[] arr2, int start2, int size2) {
        HashSet<Integer> s = new HashSet<Integer>();
        List<Integer> commonElements = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > 0) {
                s.add(arr1[i]);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (s.contains(arr2[i])) {
                commonElements.add(arr2[i]);
            }
        }
        int[] result = new int[commonElements.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = commonElements.get(i);
        }
        return result;
    }

    // Problem 03
    public static void musicalChairGame() {
        // TO DO
    }
}
