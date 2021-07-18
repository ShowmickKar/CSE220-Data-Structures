import java.util.ArrayList;

public class LinkedList {
    Node head;

    public LinkedList(int[] arr) {
        try {
            if (arr.length < 1) throw new IndexOutOfBoundsException();
            Node dummy = new Node(0);
            Node current = dummy;
            for (int i = 0; i < arr.length; i++) {
                current.next = new Node(arr[i]);
                current = current.next;
            }
            head = dummy.next;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void showList() {
        if (isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.val + " ");
        }
        System.out.println();
    }

    public void clear() {
        if (isEmpty()) {
            return;
        }
        head = null;
    }

    public void insert(Node newElement) {
        if (head == null) {
            head = newElement;
        }
        for (Node current = head; current != null; current = current.next) {
            if (current.val == newElement.val) {
                return;
            }
            if (current.next == null) {
                current.next = newElement;
            }
        }
    }

    public void insert(int newElement, int index) {
        try {
            Node newNode = new Node(newElement);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            }
            int i = 0;
            for (Node current = head; current != null; current = current.next) {
                if (i == index - 1) {
                    newNode.next = current.next;
                    current.next = newNode;
                    return;
                }
                i++;
            }
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Index is bigger than Linked List Length");
        }
    }

    public int remove(int deleteKey) {
        try {
            if (isEmpty()) return -1;
            if (head.val == deleteKey) {
                head = head.next;
                return deleteKey;
            }
            for (Node current = head; current != null; current = current.next) {
                if (current.next.val == deleteKey) {
                    Node deletedNode = current.next;
                    current.next = current.next.next;
                    return deletedNode.val;
                }
            }
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            System.out.println("key not found in the List");
        }
        return -1;
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
        while (current != null) {
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
                Node current = head.next;
                int previous = head.val;
                while (current != null) {
                    if (current.next == null) {
                        head.val = current.val;
                    }
                    int temp = current.val;
                    current.val = previous;
                    previous = temp;
                    current = current.next;
                }
            }
        }
    }
}
