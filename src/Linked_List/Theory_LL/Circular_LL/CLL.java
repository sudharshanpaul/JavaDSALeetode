package Linked_List.Theory_LL.Circular_LL;

public class CLL {

    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int value){
        Node node = new Node(value);
        if(head == null){
            head = tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
        tail.next = head;

    }

    public void insertLast(int value){
        Node node = new Node(value);

        if(head == null){
            insertFirst(value);
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    public void insert(int value, int index) {
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        Node node = new Node(value,temp.next);
        temp.next = node;
        size++;
    }

    public void deleteFirst(){
        if (head == null) {  // Empty list case
            System.out.println("List is empty.");
            return;
        }
        if(head.next == head){
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        tail.next = head;
        size--;
    }

    public Node getReference(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void deleteLast() {
        if (head == null) {  // Empty list case
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {  // Only one element
            head = tail = null;
        } else {
            Node prev = getReference(size - 2);  // Get second-last node
            prev.next = head;  // Update second-last node to point to head
            tail = prev;  // Update tail to second-last node
        }
        size--;
    }

    public void display(){
        Node temp = head;
        if(temp == null){
            System.out.println("No List Exist");
            return;
        }
        do{
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }while (temp != head);
        System.out.println(" END ");
    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
