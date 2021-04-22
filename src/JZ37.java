/**
 * @author zr
 * @create 2021-04-22-20:04
 */

import org.junit.jupiter.api.Test;

/**
 * 题目描述
 * 统计一个数字在升序数组中出现的次数。
 *
 * 示例1
 * 输入
 * [1,2,3,3,3,3,4,5],3
 *
 * 返回值
 * 4
 */
public class JZ37 {
    public int GetNumberOfK(int [] array , int k) {

        if(array==null||array.length==0||k>array[array.length-1]||k<array[0])
            return 0;

        int low = 0;
        int high = array.length-1;
        int result = 0;

        int index = 0;

        while (low<=high){
            if(array[(low+high)/2]==k){
                result++;
                break;
            }

            if(array[(low+high)/2] > k)
                low = (low+high)/2+1;

            else
                high = (low+high)/2-1;
        }

        if(low>high){
            return result;
        }

        index = (low+high)/2;

        for(int i=index+1;i<array.length&&array[i]==k;i++)
            result++;
        for (int i=index-1;i>=0&&array[i]==k;i--)
            result++;

        return result;
    }

    @Test
    public void test(){
        int []  a = {1,2,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(a, 3));
    }

}
