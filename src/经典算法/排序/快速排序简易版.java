package 经典算法.排序;

import java.util.ArrayList;
import java.util.List;

/**
 *   快速排序其实还是分治的思想，这种办法容易理解，但是空间复杂度高
 */

public class 快速排序简易版 {

    public static void quickSort(List<Integer> items) {
        //用于存放小于基数的元素
        List<Integer> smaller = new ArrayList<Integer>();
        //用于存放等于基数的元素
        List<Integer> same = new ArrayList<Integer>();
        //用于存放大于基数的元素
        List<Integer> larger = new ArrayList<Integer>();

        //选择中间元素作为基数（选择任意元素作为基数都可以）
        Integer choosenItem = items.get(items.size() / 2);
        //遍历所有元素，根据元素和基数的大小关系，将元素添加到三个list中
        for (Integer i : items) {
            if (i < choosenItem) {
                smaller.add(i);
            } else if (i == choosenItem) {
                same.add(i);
            } else {
                larger.add(i);
            }
        }

        if (smaller.size() > 1) {
            //递归排序小于基数的元素
            quickSort(smaller);
        }
        if (larger.size() > 1) {
            //递归排序大于基数的元素
            quickSort(larger);
        }

        //清除list中原来的元素
        items.clear();
        //按照大小顺序把元素添加到list中
        items.addAll(smaller);
        items.addAll(same);
        items.addAll(larger);

    }
}
