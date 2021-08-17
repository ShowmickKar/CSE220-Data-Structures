import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        // factorial
//        System.out.println(factorial(n));
//        // print the nth fibonacci number
//        // 0 1 1 2 3 5 8...
//        System.out.println(nthFibonacci(n));
//        // print all elements of a given array recursively
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        printRecursively(arr, 0);
//        // calculating power of n recursively
//        int base = scanner.nextInt();
//        n = scanner.nextInt();
//        System.out.println(powerN(base, n));
////         decimal to binary conversion
//        int decimalValue = scanner.nextInt();
//        System.out.println(decimalToBinary(decimalValue));
//        // add singly linked list nodes
//        SinglyNode node = new SinglyNode(1);
//        SinglyNode cur = node;
//        for (int i = 2; i <= 10; i++) {
//            cur.next = new SinglyNode(i);
//            cur = cur.next;
//        }
//        System.out.println(addLinkedListNodes(node));
//        // print linked list in reverse order
//        printLinkedList(node);
//        for (int i = 0; i < 4; i++) {
//            System.out.println(hocBuilder(i));
//        }
//        printPattern1(10);
//        printPattern2(5, 0);

    }

    public static int factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public static int nthFibonacci(int n) {
        if (n < 2) return n;
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    public static void printRecursively(int[] arr, int index) {
        if (index == arr.length) {
            System.out.println();
            return;
        }
        System.out.print(arr[index] + " ");
        printRecursively(arr, index + 1);
    }

    public static int powerN(int base, int n) {
        if (n == 0) return 1;
        if (n == 1) {
            return base;
        }
        return base * powerN(base, n - 1);
    }

    public static String decimalToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        char remainder = (char) (n % 2 + '0');
        return decimalToBinary(n / 2) + remainder;
    }

    public static int addLinkedListNodes(SinglyNode head) {
        if (head == null) return 0;
        return head.val + addLinkedListNodes(head.next);
    }

    public static void printLinkedList(SinglyNode head) {
        if (head == null) return;
        printLinkedList(head.next);
        System.out.println(head.val);
    }

    public static int hocBuilder(int height) {
        if (height == 0) return 0;
        if (height == 1) return 8;
        return 5 + hocBuilder(height - 1);
    }

    public static void printPattern1(int n) {
        if (n == 0) return;
        printPattern1(n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
    }
    public static void printPattern2(int n, int gap) {
        if (n == 0) return;
        printPattern2(n - 1, gap + 1);
        for (int i = 0; i < gap; i++) {
            System.out.print("  ");
        }
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
    }
}

class SinglyNode {
    int val;
    SinglyNode next;

    public SinglyNode(int n) {
        val = n;
        next = null;
    }
}
