public class DoublyLinkedList {
    Node head;

    /**
     * Constructs a Dummy Headed Doubly Linked Circular List from an Array
     *
     * @param arr
     */
    public DoublyLinkedList(int[] arr) {
        if (arr.length == 0) return;
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
        if (isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        Node current = head;
        while (true) {
            System.out.print(current.val + " ");
            current = current.next;
            if (current == head) break;
        }
        System.out.println();
    }

    /**
     * Inserts an new Node at the end of the Linked List
     *
     * @param newElement
     */

    public void insert(Node newElement) {
        if (isEmpty()) {
            head = newElement;
            head.previous = newElement;
            head.next = newElement;
        }
        Node current = head;
        while (current.next != head) {
            if (current.val == newElement.val) {
                return;
            }
            current = current.next;
        }
        if (current.val == newElement.val) return;
        current.next = newElement;
        newElement.previous = current;
        newElement.next = head;
        head.previous = newElement;
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
        while (true) {
            if (current.val == newElement) return;
            if (current == head && i > 0) {
                // Invalid Index
                return;
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
    }

    /**
     * Removes a node at a given node
     *
     * @param index
     */
    void remove(int index) {
        if (isEmpty()) return;
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
                // Index out of Bound
                return;
            }
            i += 1;
        }
    }

    /**
     * @param deleteKey
     * @return deleted Node value
     */
    public int removeKey(int deleteKey) {
        if (isEmpty()) return 0;
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
    }
}
