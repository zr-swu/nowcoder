/**
 * @author zr
 * @create 2021-03-29-20:42
 */


import java.util.ArrayList;

/**
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 *
 * In:
 * [4,5,1,6,2,7,3,8],4
 *
 * OutPut:
 * [1,2,3,4]
 *
 * Partition超时
 */
public class NC119 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {


        int size = input.length;
        if(k>size||k<=0||input==null)
            return new ArrayList<Integer>();

        int low = 0;
        int high = size-1;

        int index = Partition(input, low, high);

        while (index!=k-1){

            if(index<k-1)//说明要找的值比index位置的大  往右边找
                low = index+1;

            else
                high = index-1;


            Partition(input, low, high);
        }

        // 收集这k个数
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= index; i++) {
            res.add(input[i]);
        }
        return res;


    }


    public int Partition(int a[],int low,int high){

        int value = a[low];
        int i=low,j=high+1;


        while (true){
            while (a[++i]<value&&i<=high){}

            while (a[--j]>value&&j>=low){}

            if(i>=j)
                break;

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;

        }

        if(j!=low){
            int tmp = a[j];
            a[j] = a[low];
            a[low] = tmp;
        }

        return j;
    }


}
