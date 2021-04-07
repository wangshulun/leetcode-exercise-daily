package com.allen.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangshulun
 * @date 2021/4/7
 */
public class LRUCache {
    private static class DLinkNode {
        int key;
        int value;

        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private static Map<Integer, DLinkNode> cache = new HashMap<>();


    private static int size;

    private static int capacity;

    private static DLinkNode head;
    private static DLinkNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public static void put(int key, int value) {
        DLinkNode node = cache.get(key);

        if (node == null) {
            // 如果key不存在，添加进hash表
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                //容量超标，删除尾部节点
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            //如果key存在，更新value，移动节点到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // 查找
    public static int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }


    //节点挪到头部
    private static void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }


    //删除节点
    private static void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //头结点添加元素
    private static void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //删除尾结点
    private static DLinkNode removeTail() {
        DLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
