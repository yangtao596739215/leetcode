package 经典算法.排序.快速排序;

/**
 *
 * 这种解法使用两个变量从两端来遍历元素，采用赋值的方式来实现分治的思想，不容易理解。
 *
 *    平均时间复杂度： nlog2n
 *
 */

public class 快速排序不稳定 {

    private static void sort(int[] array, int left, int right) {
        //定义排序左边界
        int i = left;
        //定义排序右边界
        int j=right;
        //临时变量存放基数的值
        int k=array[i];

        while (i < j) {
            //j从右往左遍历找到第一个小于基数的值
            while (array[j] > k && i<j) {
                j--;
            }
            if (i<j) {
                //将找到的小于基数的值赋值给array[i]
                array[i++] = array[j];
            }
            //j从左往右遍历找到第一个大于基数的值
            while (array[i] < k && i<j) {
                i++;
            }
            if (i<j) {
                //将找到的大于基数的值赋值给array[j]
                array[j--] = array[i];
            }
        }
        //上面循环结束，array[i]左边的数都比array[i]小，右边的数都比array[i]大
        //将临时变量k赋值给array[i]
        array[i] = k;

        if (left < i-1) {
            //递归排序array[i]左边的元素
            sort(array, left, i-1);
        }
        if (i+1 < right) {
            //递归排序array[i]右边的元素
            sort(array, i+1, right);
        }
    }

    public static void main(String[] args) {

        int[] ints = {1, 2, 34, 5, 76, 8};
        sort(ints,0,ints.length-1);
        System.out.println(ints);

    }
}
