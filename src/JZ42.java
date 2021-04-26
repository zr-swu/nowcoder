/**
 * @author zr
 * @create 2021-04-26-15:25
 */

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * 示例1
 * 输入
 * [1,2,4,7,11,15],15\
 * 返回值
 * [4,11]
 */
public class JZ42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> result = new ArrayList<>();

        int low=0,high = array.length-1;


        while (low < high) {
            if (array[low] + array[high] == sum) {
                //最先找到的是最外层的  乘积是最小的
                result.add(array[low]);
                result.add(array[high]);
                break;

            } else if (array[low] + array[high] > sum) {
                high--;
            } else if (array[low] + array[high] < sum) {
                low++;
            }
        }

        return result;
    }
}
