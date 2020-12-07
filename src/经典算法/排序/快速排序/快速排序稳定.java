package 经典算法.排序.快速排序;

/**
 * 快速排序是冒泡排序的改进
 *
 *  非稳定版实现    时间复杂度： nlogn   时间复杂度可能会变成n2
 *    非稳定版实现：在指针元素和枢纽元素一样大的时候，继续移动，会导致分得的两个数组不均匀，影响性能
 *                 while(array[hi]>=key&&hi>lo){
 *                 hi--;
 *                 }
 *
 *                 while(array[lo]<=key&&hi>lo){
 *                 lo++;
 *                 }
 *
 *    把大于等于和小于等于变成等于就是不稳定的了，不稳定的版本性能好
 *
 *
 *  稳定版实现
 */
public class 快速排序稳定 {

    // 经过了一趟排序以后，所有比key小的值都在key的左边，所有比key大的值，都在key的右边
    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            // 从后往前，找到第一个比 key小的数，然后把该值移到key的位置
            while(array[hi]>=key&&hi>lo){
                hi--;
            }
            array[lo]=array[hi];

            // 从前往后，找到第一个比key大的数，然后把该值移动到之前把值移来key的那个数字那里
            while(array[lo]<=key&&hi>lo){
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        // 经过了一趟排序以后，所有比key小的值都在key的左边，所有比key大的值，都在key的右边， 不需要key参与，递归进行，完成整体排序
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 5, 2, 1, 34, 4, 54};
        sort(ints,0,ints.length-1);
        System.out.println(ints);
    }
}
