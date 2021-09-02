/*
    CSE220: Data Structures
    LAB02: Singly Linked Lists
 */

public class LinkedListTester {
    public static void main(String[] args) {
        /* created a Linked List Object */
        System.out.println("Created a Linked List with the elements - 1, 2, 3, 4, 5");
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        LinkedList list = new LinkedList(arr);

        /* Tested the show list method */
        System.out.println("The show list method: ");
        list.showList();

        /* Tested the isEmpty method */
        System.out.println("Checking if the Linked List is empty: ");
        System.out.println(list.isEmpty());

        /* tester the clear-list method */
        System.out.println("Clearing the Linked List method: ");
        list.clear();
        list.showList();
        System.out.println(list.isEmpty());

        /* Tested the insert method */
        System.out.println("Insert a new Node at the end of Linked List: input = 1->2->3->4->5-> ; insert: 6");
        arr = new int[] { 1, 2, 3, 4, 5 };
        list = new LinkedList(arr);
        list.insert(new Node(6));
        list.showList();

        /* Tested the "insert at an index" method */
        System.out.println("Insert a new Node at a given index: input = 1 2 3 4 100 5 6; insert: 6;  index : 4");
        list.insert(100, 4);
        list.showList();

        /* Tested the remove method */
        System.out.println("Remove a key in a Linked List: ");
        list.showList();
        System.out.println((list.remove(100)));
        list.showList();

        /* Task 3 */

        // Find even numbers
        System.out.println("Find even numbers and crated a new Linked List from them: ");
        arr = new int[] { 1, 2, 5, 3, 8 };
        list = new LinkedList(arr);
        list.showList();
        LinkedList evenList = list.findEvenNumbers();
        evenList.showList();
        arr = new int[] { 101, 120, 25, 91, 87, 1 };
        list = new LinkedList(arr);
        list.showList();
        evenList = list.findEvenNumbers();
        evenList.showList();

        // Find if an element exists in the list or not
        System.out.print("Check if a key exists in the Linked List: ");
        arr = new int[] { 1, 2, 5, 3, 8 };
        list = new LinkedList(arr);
        list.showList();
        System.out.println("Checking for 7: ");
        System.out.println(list.isPresent(7));
        arr = new int[] { 101, 120, 25, 91, 87, 1 };
        list = new LinkedList(arr);
        list.showList();
        System.out.println("Checking for: 1");
        System.out.println(list.isPresent(1));

        // Reverse the List
        System.out.println("Reverse a Linked List");
        arr = new int[] { 1, 2, 5, 3, 8 };
        list = new LinkedList(arr);
        list.showList();
        list.reverse();
        list.showList();

        // sort the list
        System.out.println("Sort a Linked List");
        arr = new int[] { 1, 2, 5, 3, 8 };
        list = new LinkedList(arr);
        list.showList();
        list.sort();
        list.showList();

        // print sum of list elements
        System.out.println("Print the sum of all element in a linked list");
        arr = new int[] { 1, 2, 5, 3, 8 };
        list = new LinkedList(arr);
        list.showList();
        list.printSum();

        // Rotate List
        System.out.println("Rotate a Linked List");

        // left rotate
        System.out.println("Left rotating a linked list");
        arr = new int[] { 3, 2, 5, 1, 8 };
        list = new LinkedList(arr);
        list.showList();
        list.rotate("left", 2);
        list.showList();

        // right rotate
        System.out.println("Right rotating a linked list");
        arr = new int[] { 3, 2, 5, 1, 8 };
        list = new LinkedList(arr);
        list.showList();
        list.rotate("right", 2);
        list.showList();
    }
}
