"""
Stack is a Linear Data Structure which follows the Last In First Out(LIFO)
order of operations

Stack supports four main operations

Push: Adds an item in the stack. If the stack is full, then it is said to be an Overflow condition.
Pop: Removes an item from the stack. The items are popped in the reversed order in which they are pushed. If the stack is empty, then it is said to be an Underflow condition.
Peek or Top: Returns top element of stack.
isEmpty: Returns true if stack is empty, else false.
"""


class ArrayStack:
    def __init__(self):
        self.inner_array = [0 for i in range(100)]
        self.size = 0
        self.max_size = len(self.inner_array)
        self.pointer = 0

    def push(self, element):
        try:
            if self.pointer == self.max_size:
                raise Exception("Stack Overflow")
            self.inner_array[self.pointer] = element
            self.pointer += 1
        except Exception as e:
            print(e)

    def pop(self):
        try:
            if not self.pointer:
                raise Exception("Underflow")
            self.pointer -= 1
            self.inner_array[self.pointer] = 0
        except Exception as e:
            print(e)

    def peek(self):
        return self.inner_array[self.pointer - 1] if self.pointer else None

    def isEmpty(self):
        return not self.pointer


class StackNode:
    def __init__(self, val):
        self.val = val
        self.next = None


class ListStack:
    def __init__(self):
        self.top = None
        self.size = 0
        self.max_size = 100

    def push(self, element):
        try:
            if self.size == self.max_size:
                raise Exception("Stack Overflow")
            new_node = StackNode(element)
            new_node.next = self.top
            self.top = new_node
            self.size += 1
        except Exception as e:
            print(e)

    def pop(self):
        try:
            if self.size == 0:
                raise Exception("Underflow")
            self.top = self.top.next
            self.size -= 1
        except Exception as e:
            print(e)

    def peek(self):
        return self.top.val

    def isEmpty(self):
        return self.top == None
