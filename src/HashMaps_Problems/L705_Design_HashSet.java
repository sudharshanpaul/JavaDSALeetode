package HashMaps_Problems;

import java.util.LinkedList;

public class L705_Design_HashSet {

    // https://leetcode.com/problems/design-hashset/

    static class MyHashSet {

        int n;
        int N;
        double K = 2.0;
        LinkedList<Integer>[] buckets;


        public MyHashSet() {
            N = 4;
            buckets = new LinkedList[N];
            for(int i=0; i<N; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        public int hashFunction(int key){
            return Math.abs(key % buckets.length);
        }

        public void rehash(){
            LinkedList<Integer> oldBuckets[] = buckets;
            N = N * 2;
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
            for(LinkedList<Integer> bucket: oldBuckets){
                for(int i=0; i < bucket.size(); i++){
                    add(bucket.get(i));
                }
            }
        }

        public void add(int key) {
            int bi = hashFunction(key);
            LinkedList ll = buckets[bi];
            if(ll.contains(key)){
                return;
            }else{
                n++;
                ll.add(key);
            }

            double lambda = (double)n / N;
            if(lambda > K){
                rehash();
            }

        }

        public void remove(int key) {
            int bi = hashFunction(key);
            LinkedList ll = buckets[bi];
            if(ll.contains(key)){
                n--;
                ll.remove((Integer) key);
            }
        }

        public boolean contains(int key) {
            int bi = hashFunction(key);
            LinkedList ll = buckets[bi];
            if(ll.contains(key)){
                return true;
            }else{
                return false;
            }
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
