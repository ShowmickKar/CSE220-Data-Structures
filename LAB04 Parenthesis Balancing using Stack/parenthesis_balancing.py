from stack import ArrayStack, ListStack

"""
Write a function that takes a mathematical expression and
determines whether it has the valid opening and closing bracket matching

Sample Input 1: 1+2*(3/4)
Sample Output 1: This expression is correct.

Sample Input 2: 1+2*[3*3+{4–5(6(7/8/9)+10)–11+(12*8)]+14
Sample Output 2: This expression is NOT correct.

Sample Input 3: 1+2*[3*3+{4–5(6(7/8/9)+10)}–11+(12*8)/{13+13}]+14
Sample Output 3: This expression is correct.

Sample Input 3: 1+2]*[3*3+{4–5(6(7/8/9)+10)–11+(12*8)]+14
Sample Output 3: This expression is NOT correct.

"""


def valid_closing_bracket(opening, closing):
    return (
        opening == "("
        and closing == ")"
        or opening == "{"
        and closing == "}"
        or opening == "["
        and closing == "]"
    )


def is_bracket(c):
    return c == "(" or c == ")" or c == "{" or c == "}" or c == "[" or c == "]"


def is_opening_bracket(c):
    return c == "(" or c == "{" or c == "["


# Solution using ArrayStack
#############################################################


def bracket_matching_array_stack(expression):
    stack = ArrayStack()
    for c in expression:
        if is_bracket(c):
            if is_opening_bracket(c):
                stack.push(c)
            else:
                if stack.isEmpty():
                    return False
                if valid_closing_bracket(stack.peek(), c):
                    stack.pop()
                else:
                    return False
    return stack.isEmpty()


##############################################################


# Solution using ListStack
#############################################################


def bracket_matching_list_stack(expression):
    stack = ListStack()
    for c in expression:
        if is_bracket(c):
            if is_opening_bracket(c):
                stack.push(c)
            else:
                if stack.isEmpty():
                    return False
                if valid_closing_bracket(stack.peek(), c):
                    stack.pop()
                else:
                    return False
    return stack.isEmpty()


##############################################################


# Driver Code

if __name__ == "__main__":
    """
    Driver code to test the ArrayStack and ListStack class
    """
    expressions = [
        "1+2*(3/4)",
        "1+2*[3*3+{4–5(6(7/8/9)+10)–11+(12*8)]+14",
        "1+2*[3*3+{4–5(6(7/8/9)+10)}–11+(12*8)/{13+13}]+14",
        "1+2]*[3*3+{4–5(6(7/8/9)+10)–11+(12*8)]+14",
    ]

    print("###################################")
    print("Testing the ArrayStack class")
    print("###################################")
    for i, expression in enumerate(expressions):
        print(f"Expression {i + 1}: {expression}")
        if bracket_matching_array_stack(expression):
            print("This expression is correct.")
        else:
            print("This expression is NOT correct.")
    print("###################################\n\n")

    print("###################################")
    print("Testing the ListStack class")
    print("###################################")
    for i, expression in enumerate(expressions):
        print(f"Expression {i + 1}: {expression}")
        if bracket_matching_list_stack(expression):
            print("This expression is correct.")
        else:
            print("This expression is NOT correct.")
    print("###################################")
