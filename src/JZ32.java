/**
@author zr
@create 2021-04-14-11:13
*/

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

/**
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 示例1
 * 输入
 * [3,32,321]
 *
 * 返回值
 * "321323"
 */
public class JZ32 {

    StringBuilder result = new StringBuilder();

    public String PrintMinNumber(int [] numbers) {

        result = new StringBuilder(numbers.length);

        if(numbers==null||numbers.length==0)
            return result.toString();

        for(int i=0;i<numbers.length;i++)
            result.append('9');

        AllArrange(numbers, 0);

        return  result.toString();
    }
    public void AllArrange(int[] nums,int pos){
        if(pos+1 == nums.length){
            String tmp = "";
            for(Integer i: nums){
                tmp += String.valueOf(i);
            }

            result = result.toString().compareTo(tmp)<=0?result:new StringBuilder(tmp);

            return;
        }

        for (int i=pos;i<nums.length;i++){
            int tmp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = tmp;

            AllArrange(nums, pos+1);

            tmp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = tmp;
        }


    }

    @Test
    public void test(){
        int [] a = {3,32,321};

        System.out.println(PrintMinNumber(a));
    }

}
