/**
 * @author zr
 * @create 2021-04-23-21:02
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 题目描述
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 示例1
 * 输入
 * [1,4,1,6]
 *
 * 返回值
 * [4,6]
 *
 * 说明
 * 返回的结果中较小的数排在前面
 *
 * 分析：
 * 其他数字都出现了两次  相同两个数字异或得0  0异或任何数得数本身
 * 将数组从头到尾连续异或  得到两个只出现一次的数字得异或结果
 *
 * 从右往左找到异或结果的第一个二进制1的位置 按这个位置是不是1区分数组
 *
 * 区分出来的两部分都只有1个只出现一次的数
 *
 */
public class JZ40 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here

        int [] result = new int[2];

        int resultXOR = 0;

        for(int i=0;i<array.length;i++){
            resultXOR ^= array[i];
        }

        int _46 = 4^6;

        int indexOf1 = 0;
        int tmp = resultXOR;
        while ((tmp&1)==0){
            tmp >>=1;
            indexOf1++;
        }

        int _1 = 0;
        int _2 = 0;


        for(int i=0;i<array.length;i++){
            if(((array[i]>>indexOf1)&1)==1)
                _1 ^= array[i];
            else
                _2 ^= array[i];
        }

        result[0] = _1<_2?_1:_2;
        result[1] = _1<_2?_2:_1;

        return result;
    }

    @Test
    public void test(){
        int [] a = new int[]{1,4,1,6};
        int[] ints = FindNumsAppearOnce(a);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
