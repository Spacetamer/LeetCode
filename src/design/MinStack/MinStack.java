package design.MinStack;

import java.util.EmptyStackException;
import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> data, min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        try {
            int currentMin = min.peek();
            min.push(Math.min(currentMin, x));
        } catch (EmptyStackException e){
            min.push(x);
        }
    }

    public void pop() {
        min.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
