/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

1. push(x) – Push element x onto stack.
2. pop() – Removes the element on top of the stack.
3. top() – Get the top element.
4. getMin() – Retrieve the minimum element in the stack.

Note that all the operations have to be constant time operations.

*/


class Pair {
    int number;
    int minTillNow;
}

class MinStack {
    
    Stack<Pair> stack = new Stack<Pair>();

    public void push(int x) {
        Pair pair = new Pair();
        pair.number = x;
        pair.minTillNow = stack.isEmpty() ? x : (getMin() < x ? getMin() : x);
        stack.push(pair);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peek().number;
    }

    public int getMin() {
        if (stack.isEmpty()) return -1;
        return stack.peek().minTillNow;
    }
}
