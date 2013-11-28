package util;

import java.util.HashMap;

public class LRUCache {
    
    HashMap<Integer, BiLinkNode> map = new HashMap<Integer, BiLinkNode>();
    int capacity;
    BiLinkNode head;
    BiLinkNode end;
    
    public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		cache.set(1, 13);
		cache.set(1, 12);
		cache.set(2, 11);
		System.out.println(cache.get(1));
		cache.set(2, 10);
		System.out.println(cache.get(2));
		
		
		
	}
    
    public LRUCache(int capacity) {
        map.clear();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else{
            BiLinkNode node = map.get(key);
            if(head==node)head = node.next;
            if(end==node) end = node.pre;
            if(node.pre!=null)node.pre.next = node.next;
            if(node.next!=null)node.next.pre = node.pre;
            map.remove(key);
            set(key, node.val);
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        if(map.size()==0){
            head = new BiLinkNode(key, value);
            end = head;
            map.put(key, head);
        }else if(map.containsKey(key)){
        	BiLinkNode node = map.get(key);
        	node.val = value;
        	get(key);
        }else if(map.size()<capacity){
            BiLinkNode node = new BiLinkNode(key, value);
            map.put(key, node);
            head.pre = node;
            node.next = head;
            head = node;
        }else{
        	System.out.println("Full, remove" + end.key);
        	BiLinkNode p = head;
        	while(p!=null){
        		System.out.print("[" + p.key + "," + p.val + "] ");
        		p = p.next;
        	}
        	System.out.println("");
            map.remove(end.key);
            end = end.pre;
            if(end!=null)end.next = null;
            set(key, value);
        }
    }
}

class BiLinkNode{
    int key;
    int val;
    BiLinkNode pre;
    BiLinkNode next;
    BiLinkNode(int k, int v){
        this.key = k;
        this.val = v;
    }
}