/**
 * @author zr
 * @create 2021-05-15-11:15
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 *
 * 示例1
 *
 * 输入
 * [2,3,4,2,6,2,5,1],3
 *
 * 返回值
 * [4,4,6,6,6,5]
 */
public class JZ64 {

    /**以下是对比较器升序、降序的理解.
     *(1) 写成return o1.compareTo(o2) 或者 return o1-o2表示升序
     *(2) 写成return o2.compareTo(o1) 或者return o2-o1表示降序
     */
    //大顶堆
    public PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)-> o2-o1);

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        if(num==null || num.length <= 0 || size<=0||num.length < size){
            return result;
        }
        int count = 0;

        //初始化窗口
        for(;count<size;count++){
            queue.offer(num[count]);
        }
        result.add(queue.peek());//取最大值 不删

        for (;count<num.length;count++){
            queue.remove(num[count-size]);//假如size为3 count为3  则位于第二个窗口(1 2 3)把0删除
            queue.offer(num[count]);
            result.add(queue.peek());//取最大值 不删
        }

        return result;
    }
}
