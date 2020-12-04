package 经典算法.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 借助LinkedHashMap自己维护的   最近最少使用
 *
 * LinkedHashMap的构造函数的第三个参数传true就可以了
 *
 */

public class LRU借助LinkedHashMap {
    private int capacity;
    private Map<Integer,Integer> cache;

    public LRU借助LinkedHashMap(int capacity) {

        this.cache = new LinkedHashMap<Integer, Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                // 在容量大于capacity时，就删除
                return size()>capacity;
            }
        };
        this.capacity = capacity;
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRU借助LinkedHashMap lru = new LRU借助LinkedHashMap(3);
        lru.put(1,1);
        lru.put(2,1);
        lru.put(3,1);
        lru.get(1);
        lru.put(4,4);  // 正常的话，2消失
        System.out.println(lru);
    }
}
