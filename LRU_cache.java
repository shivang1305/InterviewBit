/* STACKS & QUEUES                                                           Date: 14-July-2021
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Input:
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

Output:
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
*/

import java.util.*;


public class LRU_cache {
    class Node {
        int key;
        int val;
        
        // Doubly Linked List
        Node prev;
        Node next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    // dummy head and tail pointers
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    
    int cap; // size of LRU cache
    HashMap<Integer, Node> map = new HashMap<>(); // to store key and node address of each value

    public LRU_cache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    // Time complexity : O(1)
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
    
            removeNode(node);
            insertNode(node);
            
            return node.val;
        }
        return -1;
    }
    
    // Time complexity : O(1)
    public void put(int key, int value) {
        if(map.containsKey(key)) 
            removeNode(map.get(key));
        
        if(map.size() == cap)
            removeNode(tail.prev);
        
        insertNode(new Node(key, value));
    }
    
    private void insertNode(Node node) {
        map.put(node.key, node);
        
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        map.remove(node.key);
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

// Space complexity : O(capacity)