/**
 * @author zr
 * @create 2021-03-31-22:27
 */


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个数组，请你编写一个函数，返回该数组排序后的形式。
 */
public class NC140 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort (int[] arr) {
        // write code here

        QuickSort(arr,0,arr.length-1);

        return arr;
    }

    public void QuickSort(int [] arr,int low,int high){
        if(low>=high||low<0||high>arr.length-1)
            return;

        int pivot = Partition(arr, low, high);

        QuickSort(arr, low, pivot-1);
        QuickSort(arr, pivot+1, high);

    }

    public int Partition(int []arr,int low,int high){

        int value = arr[low];

        int i = low,j=high+1;

        while (true){
            while (++i<=high&&arr[i]<value){}

            while (--j>=low&&arr[j]>value){}

            if(i>=j)
                break;

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        if(j!=low){
            int tmp = arr[low];
            arr[low] = arr[j];
            arr[j] = tmp;
        }

        return j;
    }


    @Test
    public void test(){
        int a[] = new int[]{1,2,4,7,3,1,5,9};
        System.out.println(Arrays.toString(a));
        MySort(a);
        System.out.println(Arrays.toString(a));
    }


    /*public int[] MySort (int[] arr) {
        // write code here

        if(arr.length<=0)
            return arr;

        QuickSort(arr,0,arr.length-1);

        return arr;
    }

    public void QuickSort(int [] arr ,int low,int high){
        if(low>= high)
            return;

        int pivot = Partition(arr, low, high);

        QuickSort(arr,low,pivot-1);
        QuickSort(arr,pivot+1,high);

    }


    public int Partition(int[] a,int low ,int high){

        int value = a[low];
        int i = low;
        int j = high+1;


        while (true){

            while (a[++i]<value&&i<high){}//i是不小于value的

            while (a[--j]>value&&j>low){}//j是不大于value的

            if(i>=j)//不应该交换了 顺序是对的
                break;

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        if(j!=low){//low位置存了 value 换到中间
            int tmp = a[j];
            a[j] = a[low];
            a[low] = tmp;
        }

        return j;
    }*/
}
