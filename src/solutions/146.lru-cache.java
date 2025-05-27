package solutions;
/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start

import java.util.HashMap;

class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(Node delNode) {
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
    }

    private HashMap<Integer, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node head = new Node(0, 0), tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        int val = node.value;
        cache.remove(key);
        deleteNode(node);
        addNode(node);
        cache.put(key, head.next);
        return val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            cache.remove(key);
            deleteNode(node);
        }

        if (cache.size() == capacity) {
            cache.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key, value));
        cache.put(key, head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
