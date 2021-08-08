import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private final int maxSize = 100;
    private T[] innerArray = (T[]) new Object[maxSize];
    private int size = 0;
    private int pointer = 0;

    /**
     * pushes a new element to the stack
     *
     * @param element
     */
    @Override
    public void push(T element) {
        try {
            if (pointer == maxSize) {
                throw new StackOverflowError();
            }
            innerArray[pointer] = element;
            pointer++;
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
            if (pointer < 1) {
                throw new EmptyStackException();
            }
            pointer--;
        } catch (EmptyStackException e) {
            System.out.println(e);
        }
    }

    /**
     * @return the value of the last element of the stacks
     */
    @Override
    public T peek() {
        return (pointer > 0) ? innerArray[pointer - 1] : null;
    }

    /**
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return pointer <= 0;
    }
}
