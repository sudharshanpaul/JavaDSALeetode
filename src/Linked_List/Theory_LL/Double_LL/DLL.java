package Linked_List.Theory_LL.Double_LL;

public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = head;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    public void insertLast(int value){
        if(head == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    public Node getReference(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node findNode(int value){
        Node temp = head;
        while(temp!=null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }

    public void insert(int value, int index) {
        if(index ==0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
            return;
        }

        Node node = new Node(value);
        Node temp = head;

        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        node.next = temp.next;
        node.prev = temp;
        temp.next = node;
        node.next.prev = node;
    }

    public void insertAferValue(int value,int after){
        Node prev = findNode(after);
        if(prev == null){
            System.out.println("Node doesn't exist");
            return;
        }
        if(prev.next == null){
            insertLast(value);
            return;
        }
        Node node = new Node(value,prev,prev.next);
        prev.next = node;
        node.next.prev = node;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayReverse(){
        Node temp = tail;
        while( temp != null ){
            System.out.print(temp.value+" <- ");
            temp = temp.prev;
        }
        System.out.println("START");
    }

    private class Node{
        private int value;
        private Node prev;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
