package io.lynna.leetcode;

import java.util.HashMap;

/**
 * Created by lynna on 2017/11/19.
 */
class LRUCache {
    HashMap<Integer, ListNode> map;
    LRUList valueList;
    int LRUcapacity;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity*2);
        valueList = new LRUList();
        LRUcapacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            valueList.putToStart(node);
            return node.value;
        }
        else
            return -1;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.value = value;
            valueList.putToStart(node);
        }
        else{
            if(map.size() == this.LRUcapacity){
                map.remove(valueList.end.key);
                valueList.removeEndNode(this.LRUcapacity);
            }

            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            valueList.insertNewNode(newNode);

        }
    }
}

class LRUList {
    ListNode start = null;
    ListNode end = null;

    public void putToStart(ListNode node) {
        if(this.start != node){
            ListNode tempStart = this.start;

            if (this.end == node) {
                this.end = node.pre;
                node.pre.next = null;
                node.next = tempStart;
                node.pre = null;
                tempStart.pre = node;
                this.start = node;
                return;
            }

            node.pre.next = node.next;
            node.next.pre = node.pre;
            this.start = node;
            node.pre = null;
            node.next = tempStart;
            tempStart.pre = node;

        }
    }

    public void insertNewNode(ListNode node){
        if(this.start == null){
            this.start = node;
            this.end = node;

            return;
        }



        ListNode tempStart = this.start;
        tempStart.pre = node;
        node.next = tempStart;
        node.pre = null;
        this.start = node;

    }

    public void removeEndNode(int capacity){
        if(capacity == 1){
            this.end = null;
            this.start = null;
            return;
        }

        ListNode endPre = this.end.pre;
        endPre.next = null;
        this.end.pre = null;

        this.end = endPre;

    }
}


class ListNode{
    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
    ListNode pre;
    ListNode next;

    int value;
    int key;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */