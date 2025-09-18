package HashMaps_Problems;

import java.util.LinkedList;

public class LL706_Design_HashMap {

    // https://leetcode.com/problems/design-hashmap/

    static class MyHashMap {

        static class Node{
            int key;
            int value;
            public Node(int key, int value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // no of nodes
        private int N; // no of buckets
        private double K = 2.0;

        private LinkedList<Node>[] buckets;

        public MyHashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for(int i=0; i<N; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int getBucket(int key){
            return Math.abs(key % N);
        }

        private int searchLL(int key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return i;
                }
            }
            return -1;
        }

        public void rehash(){
            LinkedList<Node>[] oldBuckets = buckets;
            N = N * 2;
            buckets = new LinkedList[N];
            for(int i=0; i<N; i++){
                buckets[i] = new LinkedList<>();
            }

            for(LinkedList<Node> bucket: oldBuckets){
                for(int i=0; i< bucket.size(); i++){
                    Node node = bucket.get(i);
                    put(node.key, node.value);
                }
            }
        }


        public void put(int key, int value) {
            int bi = getBucket(key);
            int di = searchLL(key, bi);

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n / N;
            if(lambda > K){
                rehash();
            }


        }

        public int get(int key) {
            int bi = getBucket(key);
            int di = searchLL(key, bi);

            if(di == -1){
                return -1;
            }else{
                Node node = buckets[bi].get(di);
                return node.value;
            }

        }

        public void remove(int key) {
            int bi = getBucket(key);
            int di = searchLL(key, bi);

            if(di != -1){
                buckets[bi].remove(di);
                n--;
            }
        }
    }
}
