package 经典算法.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * 自己去实现最近最少使用的剔除
 *
 */

public class LRU朴素实现 {
    private LinkedHashMap<Integer,Integer> cache;
    private int capacity;

    public LRU朴素实现(int capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public Integer get(Integer key){
        // 如果不存在，则返回-d
        if(!cache.containsKey(key)) return -1;

        // 从链表里面移除
        Integer remove = cache.remove(key);
        // 重新加进去
        cache.put(key,remove);

        return remove;
    }

    public void put(Integer key,Integer value){
        // 已经存在，则从链表中删除
        if(cache.containsKey(key)) cache.remove(key);

        // 如果链表已满，则删除链表头
        if( capacity == cache.size()){
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        // 添加到链尾
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRU朴素实现 lru = new LRU朴素实现(3);
        lru.put(1,2);
        lru.put(3,2);
        lru.put(4,2);
        lru.get(1);
        lru.put(9,9);  // 正常情况下，3将被删除
        System.out.println(lru);
    }


}
