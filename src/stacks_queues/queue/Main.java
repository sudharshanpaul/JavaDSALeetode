package stacks_queues.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(7);
        queue.add(15);
        queue.add(4);
        queue.add(77);
        queue.add(90);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(5);
        deque.addFirst(23);
        deque.addLast(56);
        System.out.println(deque.peek());

    }
}
