/**
 * @author zr
 * @create 2021-05-13-10:33
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class JZ63 {

    ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        if(list.isEmpty())
            list.add(num);

        else{//有序插入
            int i = 0;
            while (i< list.size()&&list.get(i)<num){
                i++;
            }
            list.add(i,num);
        }
    }

    public Double GetMedian() {
        int size = list.size();
        if((size&1)==1){
            return Double.valueOf(list.get(size>>1));
        }else {
            int i = list.get((size >> 1) - 1) + list.get(size >> 1);
            return Double.valueOf(i)/2;
        }
    }

    @Test
    public void test(){
        int[] a = new int []{5,2,3,4,1,6,7,0,8};
        for(Integer i : a){
            Insert(i);
            Double aDouble = GetMedian();
            System.out.println(aDouble);
        }
    }
}
