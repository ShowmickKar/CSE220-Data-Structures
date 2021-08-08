public class Main {

    public static boolean validClosing(char opening, char closing) {
        return (opening == '(' && closing == ')') || (opening == '{' && closing == '}') || (opening == '[' && closing == ']');
    }

    public static boolean bracket(char c) {
        return c == '(' || c == '{' || c == '[' || c == ')' || c == '}' || c == ']';
    }

    public static boolean opening(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    public static boolean bracketMatchingArrayStack(String expression) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (bracket(c)) {
                if (opening(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;
                    if (validClosing(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean bracketMatchingListStack(String expression) {
        ListStack<Character> stack = new ListStack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (bracket(c)) {
                if (opening(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;
                    if (validClosing(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        String[] expressions = new String[]{"1+2*(3/4)", "1+2*[3*3+{4–5(6(7/8/9)+10)–11+(12*8)]+14", "1+2*[3*3+{4–5(6(7/8/9)+10)}–11+(12*8)/{13+13}]+14", "1+2]*[3*3+{4–5(6(7/8/9)+10)–11+(12*8)]+14"};
        System.out.println("###################################");
        System.out.println("Testing the ArrayStack class");
        System.out.println("###################################");
        for (int i = 0; i < expressions.length; i++) {
            System.out.println("Expression " + (int) (i + 1) + ": " + expressions[i]);
            System.out.println((bracketMatchingArrayStack(expressions[i])) ? "This expression is correct." : "This expression is NOT correct.");
        }
        System.out.println();
        System.out.println("###################################");
        System.out.println("Testing the ListStack class");
        System.out.println("###################################");
        for (int i = 0; i < expressions.length; i++) {
            System.out.println("Expression " + (int) (i + 1) + ": " + expressions[i]);
            System.out.println((bracketMatchingListStack(expressions[i])) ? "This expression is correct." : "This expression is NOT correct.");
        }
    }
}
