import java.util.Arrays;

/**
 * @author zr
 * @create 2021-04-12-22:35
 */

/**
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * 示例1
 * 输入
 * 复制
 * [1,-2,3,10,-4,7,2,-5]
 * 返回值
 * 复制
 * 18
 * 说明
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 */
public class JZ30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int ret = array[0];

        int tmp = 0;

        for(Integer a : array){
            if(tmp + a < 0){//无贡献
                tmp = 0;
            }else{
                tmp += a;
            }
            ret = Math.max(tmp,ret);
        }

        if(tmp==0){//全是负数
            Arrays.sort(array);
            return array[array.length-1];
        }

        return ret;

    }
}
