package stacks_queues.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws QueueException {
        CustomQueue queue = new CustomQueue(5);
        queue.insert(0);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        queue.display();
        System.out.println(queue.remove());
        queue.display();

        System.out.println("Circular Queue");
        CustomCircularQueue circularQueue = new CustomCircularQueue(5);
        circularQueue.insert(0);
        circularQueue.insert(1);
        circularQueue.insert(2);
        circularQueue.insert(3);
        circularQueue.insert(4);

        circularQueue.display();
        System.out.println(circularQueue.remove());
        circularQueue.insert(99);
        circularQueue.display();

    }

    public static void inBuilt(){
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
