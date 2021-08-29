/*
    CSE220: Data Structures
    LAB06: Searching and Sorting Algorithms
 */

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
        SortingAlgorithms s = new SortingAlgorithms();
        System.out.println("#################################################");
        System.out.println("Task 1: Sort and array Recursively using  Selection Sort algorithm");
        System.out.print("Unsorted array: ");
        s.print(arr);
        s.recursiveSelectionSort(arr, 0);
        System.out.print("After sorting: ");
        s.print(arr);
        System.out.println("#################################################\n\n\n");
        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
        System.out.println("#################################################");
        System.out.println("Task 2: Sort and array recursively using  Insertion Sort algorithm");
        System.out.print("Unsorted array: ");
        s.print(arr);
        s.recursiveInsertionSort(arr, 1);
        System.out.print("After sorting: ");
        s.print(arr);
        System.out.println("#################################################\n\n\n");
        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
        Node head = new Node(0);
        Node dummy = head;
        for (int i = 0; i < arr.length; i++) {
            dummy.next = new Node(arr[i]);
            dummy = dummy.next;
        }
        head = head.next;
        System.out.println("#################################################");
        System.out.println("Task 3: Sort a Singly Linked List using Bubble Sort algorithms");
        System.out.print("Unsorted List: ");
        s.print(head);
        s.singlyListBubbleSort(head);
        System.out.print("After Sorting: ");
        s.print(head);
        System.out.println("#################################################\n\n\n");
        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
        head = new Node(0);
        dummy = head;
        for (int i = 0; i < arr.length; i++) {
            dummy.next = new Node(arr[i]);
            dummy = dummy.next;
        }
        head = head.next;
        System.out.println("#################################################");
        System.out.println("Task 4: Sort a Singly Linked List using Selections Sort algorithms");
        System.out.print("Unsorted List: ");
        s.print(head);
        s.singlyListSelectionSort(head);
        System.out.print("After Sorting: ");
        s.print(head);
        System.out.println("#################################################\n\n\n");
        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
        DoublyNode doublyHead = new DoublyNode(0);
        DoublyNode doublyDummy = doublyHead;
        for (int i = 0; i < arr.length; i++) {
            doublyDummy.next = new DoublyNode(arr[i]);
            doublyDummy.next.prev = doublyDummy;
            doublyDummy = doublyDummy.next;
        }
        doublyHead = doublyHead.next;
        doublyHead.prev = null;
        System.out.println("#################################################");
        System.out.println("Task 5: Sort a Doubly Linked List using Insertion Sort Algorithm");
        System.out.print("Unsorted List: ");
        s.print(doublyHead);
        s.doublyListInsertionSort(doublyHead);
        System.out.print("After Sorting: ");
        s.print(doublyHead);
        System.out.println("#################################################\n\n\n");
        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
        int target = 6;
        s.recursiveSelectionSort(arr, 0);
        System.out.println("#################################################");
        System.out.println("Task 6: Implement a Binary Search algorithm recursively");
        System.out.print("Our Desired array: ");
        s.print(arr);
        System.out.println("And Target Node: " + target);
        System.out.print("The index of the element " + target + " is: ");
        System.out.println(s.binarySearch(arr, 0, arr.length - 1, target));
        System.out.println("#################################################\n\n\n");
        System.out.println("#################################################");
        System.out.println("Task 7: Implement a recursive algorithm to find the n-th fibonacci number using memoization");
        int n = 13;
        System.out.print(13 + "th fibonacci number is: ");
        System.out.println(s.nThFibonacci(n));
        System.out.println("#################################################\n\n\n");
    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " -> ");
        }
        System.out.println("null");
    }

    private void print(DoublyNode head) {
        System.out.print("null <-> ");
        for (DoublyNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " <-> ");
        }
        System.out.println("null");
    }

    public void recursiveSelectionSort(int[] arr, int index) {
        if (index == arr.length) return;
        int smallestIndex = findSmallestElement(arr, index, arr.length - 1, index);
        if (arr[smallestIndex] < arr[index]) {
            int temp = arr[smallestIndex];
            arr[smallestIndex] = arr[index];
            arr[index] = temp;
        }
        recursiveSelectionSort(arr, index + 1);
    }

    private int findSmallestElement(int[] arr, int i, int j, int smallestIndex) {
        if (i > j) return smallestIndex;
        if (arr[i] < arr[smallestIndex]) {
            smallestIndex = i;
        }
        return findSmallestElement(arr, i + 1, j, smallestIndex);
    }

    public void recursiveInsertionSort(int[] arr, int index) {
        if (index == arr.length) return;
        int cur = arr[index];
        recursiveInsertionSortHelper(arr, cur, index - 1);
        recursiveInsertionSort(arr, index + 1);
    }

    private void recursiveInsertionSortHelper(int[] arr, int cur, int i) {
        if (i < 0) {
            arr[i + 1] = cur;
            return;
        }
        if (arr[i] > cur) {
            arr[i + 1] = arr[i];
            recursiveInsertionSortHelper(arr, cur, i - 1);
            return;
        }
        arr[i + 1] = cur;
    }

    public void singlyListBubbleSort(Node head) {
        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (j.val < i.val) {
                    int temp = i.val;
                    i.val = j.val;
                    j.val = temp;
                }
            }
        }
    }

    public void singlyListSelectionSort(Node head) {
        for (Node i = head; i.next != null; i = i.next) {
            int cur = i.val;
            Node visiting = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (j.val < visiting.val) {
                    visiting = j;
                }
            }
            if (visiting.val < cur) {
                int temp = i.val;
                i.val = visiting.val;
                visiting.val = temp;
            }
        }
    }

    public void doublyListInsertionSort(DoublyNode head) {
        // for convenience, we're temporarily mutating the linked list
        head.prev = new DoublyNode(0);
        head.prev.next = head;
        head = head.prev;

        for (DoublyNode i = head.next; i != null; i = i.next) {
            int cur = i.val;
            DoublyNode j = i.prev;
            while (j.prev != null && j.val > cur) {
                j.next.val = j.val;
                if (j.prev == null) {
                    j.val = cur;
                    return;
                }
                j = j.prev;
            }
            j.next.val = cur;
        }
    }

    public int binarySearch(int[] arr, int i, int j, int target) {
        if (i > j) return -1;
        int mid = (i + j) / 2;
        if (arr[mid] == target) return mid;
        if (target > arr[mid]) {
            return binarySearch(arr, mid + 1, j, target);
        }
        return binarySearch(arr, i, (mid - 1), target);
    }

    public int nThFibonacci(int n) {
        int[] memo = new int[n];
        return nThFibonacciHelper(n - 1, memo);
    }

    private int nThFibonacciHelper(int n, int[] memo) {
        if (n < 2) return n;
        if (memo[n] > 0) return memo[n];
        memo[n] = nThFibonacciHelper(n - 1, memo) + nThFibonacciHelper(n - 2, memo);
        return memo[n];
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        next = null;
    }
}

class DoublyNode {
    int val;
    DoublyNode prev;
    DoublyNode next;

    public DoublyNode(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
}

/**
 * Output of the Tester Class
 *
 * #################################################
 * Task 1: Sort and array Recursively using  Selection Sort algorithm
 * Unsorted array: 4 5 1 3 4 6 3 6 12 3 5 33 2
 * After sorting: 1 2 3 3 3 4 4 5 5 6 6 12 33
 * #################################################
 *
 *
 *
 * #################################################
 * Task 2: Sort and array recursively using  Insertion Sort algorithm
 * Unsorted array: 4 5 1 3 4 6 3 6 12 3 5 33 2
 * After sorting: 1 2 3 3 3 4 4 5 5 6 6 12 33
 * #################################################
 *
 *
 *
 * #################################################
 * Task 3: Sort a Singly Linked List using Bubble Sort algorithms
 * Unsorted List: 4 -> 5 -> 1 -> 3 -> 4 -> 6 -> 3 -> 6 -> 12 -> 3 -> 5 -> 33 -> 2 -> null
 * After Sorting: 1 -> 2 -> 3 -> 3 -> 3 -> 4 -> 4 -> 5 -> 5 -> 6 -> 6 -> 12 -> 33 -> null
 * #################################################
 *
 *
 *
 * #################################################
 * Task 4: Sort a Singly Linked List using Selections Sort algorithms
 * Unsorted List: 4 -> 5 -> 1 -> 3 -> 4 -> 6 -> 3 -> 6 -> 12 -> 3 -> 5 -> 33 -> 2 -> null
 * After Sorting: 1 -> 2 -> 3 -> 3 -> 3 -> 4 -> 4 -> 5 -> 5 -> 6 -> 6 -> 12 -> 33 -> null
 * #################################################
 *
 *
 *
 * #################################################
 * Task 5: Sort a Doubly Linked List using Insertion Sort Algorithm
 * Unsorted List: null 4 <-> 5 <-> 1 <-> 3 <-> 4 <-> 6 <-> 3 <-> 6 <-> 12 <-> 3 <-> 5 <-> 33 <-> 2 <-> null
 * After Sorting: null 1 <-> 2 <-> 3 <-> 3 <-> 3 <-> 4 <-> 4 <-> 5 <-> 5 <-> 6 <-> 6 <-> 12 <-> 33 <-> null
 * #################################################
 *
 *
 *
 * #################################################
 * Task 6: Implement a Binary Search algorithm recursively
 * Our Desired array: 1 2 3 3 3 4 4 5 5 6 6 12 33
 * And Target Node: 6
 * The index of the element 6 is: 9
 * #################################################
 *
 *
 *
 * #################################################
 * Task 7: Implement a recursive algorithm to find the n-th fibonacci number using memoization
 * 13th fibonacci number is: 144
 * #################################################
 *
 * Process finished with exit code 0
 */
