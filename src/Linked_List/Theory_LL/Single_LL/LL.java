package Linked_List.Theory_LL.Single_LL;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this .size = 0;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail==null){
            tail = head;
        }
        size++;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
        }
        else{
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void insert(int value, int index){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
            return;
        }
        if(index>size){
            System.out.println("List is of not that size");
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

    // Insert Using Recursion

    public void insertUsingRecursion(int value,int index){
        Node node = new Node(value);
        if(index==0){
            node.next = head;
            head = node;
            if(tail == null){
                tail = head;
            }
            size++;
            return;
        }
        Node req = helperInsertion(head,index-1);
        if(req == null){
            System.out.println("Insertion is not possible");
            return;
        }

        node.next = req.next;
        req.next = node;
        size++;

    }
    private Node helperInsertion(Node node, int index){
        if(index == 0){
            return node;
        }
        if(node == null){
            return null;
        }
        return helperInsertion(node.next,index-1);
    }

    public void insertRec(int value,int index){
        head = insertRec(value,index,head);
    }

    private Node insertRec(int value,int index,Node node){
        if(index == 0){
            Node tempNode = new Node(value,node);
            size++;
            return tempNode;
        }

        node.next = insertRec(value,index-1,node.next);
        return node;
    }

    public int deleteFirst(){
        int value = head.value;
        head = head.next;
        if ( head == null ){
            tail = null;
        }
        size--;
        return value;
    }

    private Node getReference(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private Node findNode(int value){
        Node temp = head;
        while( temp != null ){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast = getReference(size - 2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        return value;

    }

    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }if(index==size-1){
            return deleteLast();
        }
        Node prev = getReference(index-1);
        int value = prev.next.value;
        prev.next = prev.next.next;

        return value;

    }

    public void reverseLL(){
        head = reverseLL(null,head,head);
    }

    private Node reverseLL(Node prev, Node cur, Node next){
        if(next == null){
            return prev;
        }
        next = next.next;
        cur.next = prev;
        return reverseLL(cur,next,next);
    }

    public void reverseLLIter(){
        Node prev = null;
        Node cur = head;
        Node next = head;
        while(next != null){
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    private static class Node{
        private final int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value  = value;
            this.next = next;
        }
    }

}
