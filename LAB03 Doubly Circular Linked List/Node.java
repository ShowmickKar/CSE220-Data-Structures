public class Node {
    int val;
    Node previous;
    Node next;

    public Node(int data) {
        val = data;
        previous = this;
        next = this;
    }
}
