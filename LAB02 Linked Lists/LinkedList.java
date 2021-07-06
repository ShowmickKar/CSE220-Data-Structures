import java.util.ArrayList;

public class LinkedList {
    Node head;

    public LinkedList(int[] arr) {
        Node dummy = new Node(0);
        Node current = dummy;
        for (int i = 0; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        head = dummy.next;
    }

    public LinkedList() {
        head = null;
    }

    public boolean empty() {
        return head == null;
    }

    public void showList() {
        if (empty()) {
            System.out.println("Empty");
            return;
        }
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.val + " ");
        }
        System.out.println();
    }

    public void clear() {
        if (empty()) {
            return;
        }
        head = null;
    }

    public void insert(Node newElement) {
        for (Node current = head; current != null; current = current.next) {
            if (current.val == newElement.val) {
                return;
            }
            if (current.next == null) {
                current.next = newElement;
            }
        }
    }

    public void insert(Node newElement, int index) {
        if (empty()) {
            return;
        }
        int length = 0;
        for (Node current = head; current != null; current = current.next) {
            length++;
            if (current.val == newElement.val || length >= index) {
                return;
            }
        }
        int i = 0;
        for (Node current = head; current != null; current = current.next) {
            if (i == index) {
                newElement.next = current.next;
                current.next = newElement;
                return;
            }
            i++;
        }
    }

    public Node remove(int deleteKey) {
        if (empty()) return null;
        for (Node current = head; current != null; current = current.next) {
            if (current.next.val == deleteKey) {
                Node deletedNode = current.next;
                current.next = current.next.next;
                return deletedNode;
            }
        }
        return null;
    }

    public LinkedList findEvenNumbers() {
        Node result = new Node(0);
        Node dummy = result;
        for (Node current = head; current != null; current = current.next) {
            if (current.val % 2 == 0) {
                dummy.next = new Node(current.val);
                dummy = dummy.next;
            }
        }
        LinkedList ans = new LinkedList();
        ans.head = result.next;
        return ans;
    }

    public boolean isPresent(int element) {
        for (Node current = head; current != null; current = current.next) {
            if (current.val == element) {
                return true;
            }
        }
        return false;
    }

    public void reverse() {
        Node previous = null;
        Node current = head;
        while (current.next != null) {
            Node after = current.next;
            current.next = previous;
            previous = current;
            current = after;
        }
        head = previous;
    }

    public void sort() {
        for (Node ptr1 = head; ptr1.next != null; ptr1 = ptr1.next) {
            for (Node ptr2 = ptr1.next; ptr2 != null; ptr2 = ptr2.next) {
                if (ptr2.val < ptr1.val) {
                    int temp = ptr1.val;
                    ptr1.val = ptr2.val;
                    ptr2.val = temp;
                }
            }
        }
    }

    public void printSum() {
        int sum = 0;
        for (Node current = head; current != null; current = current.next) {
            sum += current.val;
        }
        System.out.println(sum);
    }

    public void rotate(String direction, int k) {
        if (direction == "left") {
            for (int i = 0; i < k; i++) {
                int temp = head.val;
                for (Node current = head; current != null; current = current.next) {
                    if (current.next == null) {
                        current.val = temp;
                    } else {
                        current.val = current.next.val;
                    }
                }

            }
        } else {
            for (int i = 0; i < k; i++) {
                Node runner = head.next;
                Node walker = head;
                while (runner != null) {
                    if (runner.next == null) {
                        head.val = runner.val;
                    }
                    runner.val = walker.val;
                    runner = runner.next;
                    walker = walker.next;
                }
            }
        }
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }
}
