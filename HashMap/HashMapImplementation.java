package HashMap;

import java.util.*;

public class HashMapImplementation {

    static class Hashmap<K, V> { // using generics as we are not sure what we will be storing

        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of elements stored in the hashMap
        private int N;
        private LinkedList<Node>[] buckets; // array of LinkedLists for chaining

        @SuppressWarnings("unchecked")
        public Hashmap() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> ll = buckets[bucketIndex];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) { // Use equals() instead of ==
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash() {
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // reset element count
            n = 0;

            // rehash all the elements from old bucket
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) { // O(1) amortized
            int bucketIndex = hashFunction(key);
            int di = searchInLL(key, bucketIndex);

            if (di != -1) {
                Node currNode = buckets[bucketIndex].get(di);
                currNode.value = value;
            } else {
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) { // threshold for rehashing
                reHash();
            }
        }

        public boolean containsKey(K key) { // O(1)
            int bucketIndex = hashFunction(key);
            int di = searchInLL(key, bucketIndex);

            return di != -1;
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int di = searchInLL(key, bucketIndex);

            if (di != -1) {
                Node currNode = buckets[bucketIndex].get(di);
                return currNode.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int di = searchInLL(key, bucketIndex);

            if (di != -1) {
                Node currNode = buckets[bucketIndex].remove(di); // Remove the node from the linked list
                n--;
                return currNode.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        Hashmap<String, Integer> map = new Hashmap<>();
        map.put("Shishir", 100);
        map.put("Bibhushit", 200);
        map.put("Raj", 300);
        map.put("Binayak", 400);

        ArrayList<String> keys = map.keySet();
        System.out.println(keys);
    }
}
