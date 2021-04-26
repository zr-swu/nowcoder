/**
 * @author zr
 * @create 2021-04-23-22:06
 */

import java.util.ArrayList;

/**
 *  题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
 * 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 返回值描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 示例1
 * 输入
 * 9
 * 返回值
 * [[2,3,4],[4,5]]
 */
public class JZ41 {

    /**
     * 滑动窗口解法
     * 窗口中的和若小于sum 扩大窗口 h++
     * 窗口中的和若大于sum 缩小窗口 l++
     * 题目要求至少包括两个数  所以l增到sum/2时就可以停了
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(sum<=0)
            return result;

        int low = 1 ,high = 1;

        int localSum = 0;

        while (low<=sum/2){
            if(localSum<sum){
                localSum += high;
                high++; //扩大窗口
            }else if(localSum>sum){
                localSum -= low;
                low++;
            }else {
                ArrayList<Integer> oneResult = new ArrayList<>();
                for (int i=low;i<high;i++){
                    oneResult.add(i);
                }
                result.add(oneResult);
                localSum -= low;
                low++;
            }
        }


        return result;
    }
}
