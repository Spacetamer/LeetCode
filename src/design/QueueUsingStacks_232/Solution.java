package design.QueueUsingStacks_232;


import java.util.ArrayDeque;
import java.util.Queue;

class MyQueue {

    /** Initialize your data structure here. */
    private Queue<Integer> queue;

    public MyQueue() {
        queue = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
