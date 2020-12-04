package 归并;

/**
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 *
 * 输入
 * [1,2,3,4,5,6,7,0]
 *
 * 返回值
 * 7
 */

public class 数组中的逆序对 {
    public int InversePairs(int[] array) {
      return mergeSort(array,new int[array.length],0,array.length-1);
    }

    public int mergeSort(int[] array, int[] tmp, int low, int high) {
        if (low >= high) return 0;
        int res = 0, mid = low + (high - low) / 2;
        res += mergeSort(array, tmp, low, mid);
        res %= 1000000007;
        res += mergeSort(array, tmp, mid + 1, high);
        res %= 1000000007;
        res += merge(array, tmp, low, mid, high);
        res %= 1000000007;
        return res;
    }

    public int merge(int[] array, int[] tmp, int low, int mid, int high) {
        int h1 = low, h2 = mid + 1, dec = low;
        int res = 0;
        while (h1 <= mid && h2 <= high) {
            if (array[h1] > array[h2]) {
                res += mid - h1 + 1;
                res %= 1000000007;
                tmp[dec++] = array[h2++];
            } else {
                tmp[dec++] = array[h1++];
            }
        }
        while (h1 <= mid) {
            tmp[dec++] = array[h1++];
        }
        while (h2 <= high) {
            tmp[dec++] = array[h2++];
        }
        for (int i = low; i <= high; i++) {
            array[i] = tmp[i];
        }
        return res;
    }
}
