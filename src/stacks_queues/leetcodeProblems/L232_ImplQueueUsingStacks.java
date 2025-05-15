package stacks_queues.leetcodeProblems;

import java.util.Stack;

public class L232_ImplQueueUsingStacks {
    public static void main(String[] args) {
        // Solution of the problem is "MyQueuePushEfficient"
    }

}

class MyQueuePushEfficient {

    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueuePushEfficient() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while(!first.empty()){
            second.push(first.pop());
        }
        int removed = second.pop();

        while(!second.empty()){
            first.push(second.pop());
        }

        return removed;
    }

    public int peek() {
        while(!first.empty()){
            second.push(first.pop());
        }
        int peeked = second.peek();

        while(!second.empty()){
            first.push(second.pop());
        }

        return peeked;
    }

    public boolean empty() {
        return first.empty();
    }
}


class MyQueuePopEfficient {

    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueuePopEfficient() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        while(!first.empty()){
            second.push(first.pop());
        }
        first.push(x);
        while(!second.empty()){
            first.push(second.pop());
        }
    }

    public int pop() {
        return first.pop();
    }

    public int peek() {
        return first.peek();
    }

    public boolean empty() {
        return first.empty();
    }
}
