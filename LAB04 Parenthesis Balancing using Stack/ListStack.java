import java.util.EmptyStackException;

public class ListStack<T> implements Stack<T> {
    private int size = 0;
    private StackNode top = null;
    private final int maxSize = 100;

    /**
     * pushes a new element to the stack
     *
     * @param element
     */
    @Override
    public void push(T element) {
        try {
            if (size == maxSize) {
                throw new StackOverflowError();
            }
            StackNode newNode = new StackNode(element);
            newNode.next = top;
            top = newNode;
            size++;
        } catch (StackOverflowError e) {
            System.out.println(e);
        }
    }

    /**
     * pops the last element from the stack
     */
    @Override
    public void pop() {
        try {
            if (size == 0) {
                throw new EmptyStackException();
            }
            top = top.next;
            size--;
        } catch (EmptyStackException e) {
            System.out.println(e);
        }
    }

    /**
     * @return the value of the last element of the stacks
     */
    @Override
    public T peek() {
        return (T) top.val;
    }

    /**
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    static class StackNode<E> {
        E val;
        StackNode next;

        public StackNode(E data) {
            val = data;
            next = null;
        }
    }
}
