package stacks_queues.stack;

import java.util.Stack;

public class Main {

    public static void main(String[] args) throws StackException  {
        DynamicStack stack = new DynamicStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(7);

        System.out.println(stack.peek());

    }

    public static void inBuilt(){
        Stack<Integer> stack = new Stack<>();

        stack.push(34);
        stack.push(77);
        stack.push(52);
        stack.push(9);
        stack.push(18);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
