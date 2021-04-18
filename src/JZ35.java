/**
 * @author zr
 * @create 2021-04-18-21:12
 */

import com.sun.scenario.effect.Merge;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 对于50%的数据,size≤10^4
 *
 *
 * 对于75%的数据,size≤10^5
 *
 *
 * 对于100%的数据,size≤2*10^5
 *
 *
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 示例1
 * 输入
 * [1,2,3,4,5,6,7,0]
 * 返回值
 * 7
 *
 */
public class JZ35 {

    int result = 0;

    public int InversePairs(int [] array) {

        MergeSort(array, 0, array.length-1);
        return result;
    }

    public void MergeSort(int[] a ,int low,int high){
        if(low==high){
            return;
        }
        int mid = (low+high)>>1;

        MergeSort(a,low, mid);
        MergeSort(a, mid+1, high);

        Merge(a,low ,mid, high);
    }

    public void Merge(int[]a ,int low,int mid,int high){
        int []temp = new int[high-low+1];

        int p1 = low,p2 = mid+1;
        int i=0;
        while (p1<=mid && p2<=high){
            if(a[p1]<=a[p2])
                temp[i++] = a[p1++];
            else {
                temp[i++] = a[p2++];
                result += mid-p1+1; //p1到mid之间的都比i大
                result %= 1000000007;
            }
        }
        while(p1<=mid){
            temp[i++] = a[p1++];
        }
        while (p2<=high){
            temp[i++] = a[p2++];
        }

        for (i=0;i<temp.length;i++){
            a[low+i] = temp[i];
        }
    }

    @Test
    public void test(){
        int [] a = new int[]{1,7,2,5,4,8};
        InversePairs(a);
        Arrays.stream(a).forEach(System.out::println);

    }
}
