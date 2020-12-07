package 经典算法.查找算法;

/**
 * 输入的序列必须是有序的
 */

public class 二分查找 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 6, 9, 34, 54};
        int search = search(ints, 3, 0, ints.length - 1);
        System.out.println(search);
    }


    public static int search(int[] arr, int value, int start, int end) {

        if (start >= end) return -1;

        int mid = (start + end) / 2;

        // 如果刚好是中间，则之间返回
        if (value == arr[mid]) {
            return mid;
        // 小于则取左边找
        } else if (value < arr[mid]) {
            return search(arr, value, start, mid);
        // 大于则去右边找
        } else  {
            return search(arr, value, mid + 1, end);
        }

    }
}
