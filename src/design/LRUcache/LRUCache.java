package design.LRUcache;

import java.util.HashMap;

public class LRUCache {

    private Node head, tail;
    private HashMap<Integer, Node> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.last = head;

        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null){
            removeNode(node);
            addNode(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) removeNode(node);

        node = new Node(key, value);
        addNode(node);
        cache.put(key, node);
        if (cache.size() > capacity) {
            int popKey = head.next.key;
            removeNode(head.next);
            cache.remove(popKey);
        }
    }

    private void addNode(Node node){
        System.out.println("this.tail"+tail);
        node.last = this.tail.last;
        node.last.next = node;
        node.next = tail;
        tail.last = node;
    }

    private void removeNode(Node node){
        node.last.next = node.next;
        node.next.last = node.last;
    }

    private class Node{
        int key, value;
        Node last, next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.last = null;
            this.next = null;
        }

        public Node(){
            this.last = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
