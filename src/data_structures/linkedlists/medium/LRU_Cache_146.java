package data_structures.linkedlists.medium;

import java.util.HashMap;
import java.util.Map;

class DoublyLinkedNode {
    int key;
    int value;
    DoublyLinkedNode next;
    DoublyLinkedNode prev;

    public DoublyLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRU_Cache_146 {

    private final Map<Integer, DoublyLinkedNode> cacheMap;
    private final DoublyLinkedNode head;
    private final DoublyLinkedNode tail;
    private final int maxCacheSize;
    private int currentCacheSize;

    public LRU_Cache_146(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
        this.cacheMap = new HashMap<>();
        this.currentCacheSize = 0;
        head = new DoublyLinkedNode(0, 0);
        tail = new DoublyLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        DoublyLinkedNode node = cacheMap.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            DoublyLinkedNode node = cacheMap.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            DoublyLinkedNode node = new DoublyLinkedNode(key, value);
            cacheMap.put(key, node);
            addToHead(node);
            currentCacheSize++;
            if (currentCacheSize > maxCacheSize) {
                DoublyLinkedNode tail = removeTail();
                cacheMap.remove(tail.key);
                currentCacheSize--;
            }
        }
    }

    private DoublyLinkedNode removeTail() {
        DoublyLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(DoublyLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DoublyLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoublyLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRU_Cache_146 lruCache = new LRU_Cache_146(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println("Get(1): " + lruCache.get(1));

        lruCache.put(3, 3);
        System.out.println("Get(2): " + lruCache.get(2));

        lruCache.put(4, 4);
        System.out.println("Get(1): " + lruCache.get(1));
        System.out.println("Get(3): " + lruCache.get(3));
        System.out.println("Get(4): " + lruCache.get(4));
    }
}
