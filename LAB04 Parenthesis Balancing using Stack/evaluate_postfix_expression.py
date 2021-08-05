from stack import ArrayStack


def isOperator(c):
    return c == "*" or c == "/" or c == "^" or c == "+" or c == "-"


def evaluate(operand_1, operand_2, operator):
    if operator == "+":
        return int(operand_1) + int(operand_2)
    if operator == "-":
        return int(operand_1) - int(operand_2)
    if operator == "*":
        return int(operand_1) * int(operand_2)
    if operator == "/":
        return int(operand_1) / int(operand_2)
    if operator == "^":
        return int(operand_1) ^ int(operand_2)


def evaluate_expression(postfix_expression):
    stack = ArrayStack()
    for ch in postfix_expression:
        if isOperator(ch):
            operand_2 = stack.peek()
            stack.pop()
            operand_1 = stack.peek()
            stack.pop()
            stack.push(evaluate(operand_1, operand_2, ch))
        else:
            stack.push(float(ch))
    return stack.peek()


postfix_expression = "12+34-/5+"
print(evaluate_expression(postfix_expression))
