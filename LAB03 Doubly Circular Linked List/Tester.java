public class Tester {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        // Creating an instance of a Doubly Linked Circular List
        DoublyLinkedList list = new DoublyLinkedList(arr);
        // Show List Method
        list.showList();
        // Insert at the end
        list.insert(new Node(8));
        list.showList();
        list.insert(new Node(8));
        list.showList(); // trying to insert an existing element
        // Insert at a given index
        list.insert(100, 0); // Inserting at the beginning
        list.showList();
        list.insert(200, 4); // Inserting in the middle
        list.showList();
        list.insert(300, 16); // Testing with an invalid index
        list.showList();
        list.insert(200, 6); // Trying to insert an existing element
        list.showList();
        // Remove at a given index
        list.remove(0); // Removing at the beginning
        list.showList();
        list.remove(3); // Removing in the middle
        list.showList();
        list.remove(7); // Removing at the last index
        list.showList();
        list.remove(14); // Calling the remove function with and invalid index
        list.showList();
        // Delete a given key
        System.out.println(list.removeKey(3));
        list.showList();
        System.out.println(list.removeKey(100)); // Calling the removeKey method with a nonexistent element
        list.showList();
    }
}
