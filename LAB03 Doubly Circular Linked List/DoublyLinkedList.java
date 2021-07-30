import java.util.EmptyStackException;

public class DoublyLinkedList {
    Node head;

    /**
     * Constructs a Dummy Headed Doubly Linked Circular List from an Array
     *
     * @param arr
     */
    public DoublyLinkedList(int[] arr) {
        if (arr.length == 0) {
            head = null;
            return;
        }
        head = new Node(arr[0]);
        Node dummyHead = head;
        for (int i = 1; i < arr.length; i++) {
            Node current = new Node(arr[i]);
            dummyHead.next = current;
            current.previous = dummyHead;
            dummyHead = dummyHead.next;
        }
        dummyHead.next = head;
        head.previous = dummyHead;
    }

    private boolean isEmpty() {
        return head == null;
    }

    /**
     * Displays the Doubly Linked List on Console
     */
    public void showList() {
        try {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            Node current = head;
            while (true) {
                System.out.print(current.val + " ");
                current = current.next;
                if (current == head) break;
            }
            System.out.println();
        } catch (EmptyStackException e) {
            System.out.println("Empty List");
        }
    }

    /**
     * Inserts an new Node at the end of the Linked List
     *
     * @param newElement
     */

    public void insert(Node newElement) {
        if (isEmpty()) {
            head = newElement;
            return;
        }
        Node current = head;
        while (true) {
            if (current.val == newElement.val || current.next.val == newElement.val) {
                return;
            }
            current = current.next;
            if (current.next == head) {
                current.next = newElement;
                newElement.previous = current;
                newElement.next = head;
                head.previous = newElement;
            }
        }
    }

    /**
     * Inserts a New Node at a given Index
     *
     * @param newElement
     * @param index
     */
    public void insert(int newElement, int index) {
        Node node = new Node(newElement);
        if (index == 0) {
            if (newElement == head.val) return;
            node.previous = head.previous;
            head.previous.next = node;
            node.next = head;
            head.previous = node;
            head = node;
            return;
        }
        int i = 0;
        Node current = head;
        try {
            while (true) {
                if (current.val == newElement) return;
                if (current == head && i > 0) {
                    throw new IndexOutOfBoundsException();
                }
                if (i + 1 == index) {
                    node.previous = current;
                    current.next.previous = node;
                    node.next = current.next;
                    current.next = node;
                    return;
                }
                current = current.next;
                i += 1;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Invalid Index");
        }
    }

    /**
     * Removes a node at a given node
     *
     * @param index
     */
    void remove(int index) {
        try {
            if (isEmpty()) throw new EmptyStackException();
            Node current = head;
            int i = 0;
            while (true) {
                if (i == index) {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    if (i == 0) {
                        head = current.next;
                    }
                    return;
                }
                current = current.next;
                if (current == head) {
                    throw new IndexOutOfBoundsException();
                }
                i++;
            }
        } catch (EmptyStackException e) {
            System.out.println("List is empty");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Index");
        }
    }

    /**
     * @param deleteKey
     * @return deleted Node value
     */
    public int removeKey(int deleteKey) {
        try {
            if (isEmpty()) throw new EmptyStackException();
            Node current = head;
            while (true) {
                if (current.val == deleteKey) {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    if (current == head) {
                        head = current.next;
                    }
                    return deleteKey;
                }
                current = current.next;
                if (current == head) {
                    break;
                }
            }
            return (current.val == deleteKey ? deleteKey : 0); // key is not present in the list
        } catch (Exception e) {
            System.out.println("List is empty");
        }
        return 0;
    }
}
