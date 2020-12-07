package 经典算法.排序.归并排序;

public class 归并排序 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 5, 2, 1, 34, 4, 54};
        int[] temp = new int[ints.length];
        sort(ints, temp, 0, ints.length - 1);
        System.out.println(ints);
    }

    private static void sort(int[] ints, int[] temp, int start, int end) {
        if (start < end) {

            int mid = (start + end) / 2;
            sort(ints, temp, start, mid);
            sort(ints, temp, mid + 1, end);
            merge(ints, temp, start, mid, end);
        }

    }

    private static void merge(int[] ints, int[] temp, int start, int mid, int end) {
        if (start >= end) return;
        int index = start;
        int s = start;
        // 这里要特别注意，不然会引起空指针异常
        int m = mid+1;
        while (s <= mid && m <= end) {
            if (ints[s] < ints[m]) {
                temp[index++] = ints[s++];
            } else {
                temp[index++] = ints[m++];
            }
        }
        while (s <= mid) temp[index++] = ints[s++];
        while (m <= end) temp[index++] = ints[m++];

        for (int i = start; i <= end; i++) {
            ints[i] = temp[i];
        }
    }
}
