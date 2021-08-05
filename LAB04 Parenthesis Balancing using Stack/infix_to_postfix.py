"""
Given a valid infix expression, convert it to postfix using stack
"""

"""
Algorithm

Infix expressions are readable and solvable by humans.
We can easily distinguish the order of operators, and also can use the parenthesis to solve that part first during solving mathematical expressions.
The computer cannot differentiate the operators and parenthesis easily
That’s why postfix conversion is needed.

To convert infix expression to postfix expression, we will use the stack data structure.
By scanning the infix expression from left to right, when we will get any operand, 
simply add them to the postfix form, and for the operator and parenthesis, 
add them in the stack maintaining the precedence of them.

"""

from stack import ArrayStack, ListStack


def isOperand(c):
    return c == "*" or c == "/" or c == "^" or c == "+" or c == "-"


def precedence(c):
    if c == "+" or c == "-":
        return 0
    if c == "*" or c == "/" or c == "%":
        return 1
    if c == "^":
        return 2
    return -1


def infix_to_postfix(expression):
    stack = ArrayStack()
    postfix_expression = ""
    for ch in expression:
        if ch == " ":
            continue
        if ch.isalnum():
            postfix_expression += ch
        elif ch == "(":
            stack.push(ch)
        elif ch == ")":
            while not stack.isEmpty() and stack.peek() != "(":
                postfix_expression += stack.peek()
                stack.pop()
            if not stack.isEmpty():
                stack.pop()
        else:
            if stack.isEmpty() or precedence(ch) > precedence(stack.peek()):
                stack.push(ch)
            else:
                while not stack.isEmpty() and precedence(ch) <= precedence(
                    stack.peek()
                ):
                    postfix_expression += stack.peek()
                    stack.pop()
                stack.push(ch)
    while not stack.isEmpty():
        postfix_expression += stack.peek()
        stack.pop()
    return postfix_expression


expression = input()
print(infix_to_postfix(expression))
