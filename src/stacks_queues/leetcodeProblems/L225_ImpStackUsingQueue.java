package stacks_queues.leetcodeProblems;

import com.sun.source.tree.WhileLoopTree;

import java.util.LinkedList;
import java.util.Queue;

public class L225_ImpStackUsingQueue {

    public static void main(String[] args) {

    }
}

// Insertion Efficient
class MyStack {
    Queue<Integer> first;
    Queue<Integer> second;

    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    public void push(int x) {
        first.add(x);
    }

    public int pop() {
        int len = first.size();
        for (int i = 0; i < len - 1; i++) {
            second.add(first.remove());
        }
        int removed = first.remove();
        while(!second.isEmpty()){
            first.add(second.remove());
        }
        return removed;
    }

    public int top() {
        int i = 0;
        int ans = 0;
        while(!first.isEmpty()){
            ans = first.remove();
            second.add(ans);
        }
        while(!second.isEmpty()){
            first.add(second.remove());
        }
        return ans;
    }

    public boolean empty() {
        return first.isEmpty();
    }
}

class MyStackDeletionEfficient{
    Queue<Integer> first;
    Queue<Integer> second;
    MyStackDeletionEfficient(){
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    public void push(int x){
        int len = first.size();
        for (int i = 0; i < len; i++) {
            second.add(first.remove());
        }
        first.add(x);
        for (int i = 0; i < len; i++) {
            first.add(second.remove());
        }
    }
    public int pop(){
        return first.remove();
    }
    public int peek(){
        int ans = first.remove();
        int len = first.size();
        for (int i = 0; i < len; i++) {
            second.add(first.remove());
        }
        first.add(ans);
        for (int i = 0; i < len; i++) {
            first.add(second.remove());
        }
        return ans;
    }
    public boolean isEmpty(){
        return first.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
