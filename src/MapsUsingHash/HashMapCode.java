package MapsUsingHash;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {

    static class MyHashMap<K, V>{
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n - number of Nodes
        private int N; // N - No of buckets
        private double K = 2.0;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public MyHashMap(){
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }

        }

        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];

            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            this.N = this.N*2;
            buckets = new LinkedList[N];

            for(int i=0; i<N; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i< oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.get(i);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){ // key doesn't exist
                buckets[bi].add(new Node(key, value));
                n++;
            }else{  // key exist
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double)n/N;
            if(lambda > K){
                rehash();
            }
        }
        public boolean contains(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){ // key doesn't exist
                return false;
            }else{  // key exist
                return true;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){ // key doesn't exist
                return null;
            }else{  // key exist
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;

            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){ // key doesn't exist
                return null;
            }else{  // key exist
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(LinkedList<Node> ll : buckets){
                for(int i=0; i<ll.size(); i++){
                    Node node = ll.get(i);
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> hashmap = new MyHashMap<>();
        hashmap.put("India", 130);
        hashmap.put("China", 120);
        hashmap.put("USA", 100);
        System.out.println(hashmap.keySet());
        System.out.println(hashmap.get("USA"));

        ArrayList<String> keys = hashmap.keySet();
        for(String key:keys){
            System.out.println(key + ":" + hashmap.get(key));
        }

    }
}
