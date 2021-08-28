public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
        SortingAlgorithms s = new SortingAlgorithms();
//        s.print(arr);
//        s.recursiveSelectionSort(arr, 0);
//        s.print(arr);
//        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
//        s.print(arr);
//        s.recursiveInsertionSort(arr, 1);
//        s.print(arr);
//        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
//        Node head = new Node(0);
//        Node dummy = head;
//        for (int i = 0; i < arr.length; i++) {
//            dummy.next = new Node(arr[i]);
//            dummy = dummy.next;
//        }
//        head = head.next;
//        s.print(head);
//        s.singlyListBubbleSort(head);
//        s.print(head);
//        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
//        Node head = new Node(0);
//        Node dummy = head;
//        for (int i = 0; i < arr.length; i++) {
//            dummy.next = new Node(arr[i]);
//            dummy = dummy.next;
//        }
//        head = head.next;
//        s.print(head);
//        s.singlyListSelectionSort(head);
//        s.print(head);
//        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
//        DoublyNode head = new DoublyNode(0);
//        DoublyNode dummy = head;
//        for (int i = 0; i < arr.length; i++) {
//            dummy.next =  new DoublyNode(arr[i]);
//            dummy.next.prev = dummy;
//            dummy = dummy.next;
//        }
//        head = head.next;
//        head.prev = null;
//        s.print(head);
//        s.doublyListInsertionSort(head);
//        s.print(head);
//        arr = new int[]{4, 5, 1, 3, 4, 6, 3, 6, 12, 3, 5, 33, 2};
//        s.recursiveSelectionSort(arr, 0);
//        s.print(arr);
//        System.out.println(s.binarySearch(arr, , arr.length - 1, 6));
//        int n = 13;
//        System.out.println(s.nThFibonacci(n));
    }

    private void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
        System.out.println();
    }

    private void print(DoublyNode head) {
        for (DoublyNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + " ");
        }
        System.out.println();
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
