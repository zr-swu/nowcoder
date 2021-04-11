/**
 * @author zr
 * @create 2021-04-11-22:25
 */

import java.util.Arrays;
import java.util.HashMap;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 示例1
 * 输入
 * [1,2,3,2,2,2,5,4,2]
 * 返回值
 * 2
 */
public class JZ28 {
    public int MoreThanHalfNum_Solution(int [] array) {

        int count = 0;
        int win = 0;

        for(int solider : array){
            if(count==0){
                win = solider;
                count = 1;
            }else if(solider==win){
                count++;//一伙的
            }
            else if(solider!=win){
                count--;//一换一
            }
        }

        int time=0;
        for(int i:array){
            if(i==win)
                time++;
        }
        return time>array.length/2?win:0;

    }
    /*public int MoreThanHalfNum_Solution(int [] array) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i:array){
            if(map.get(i)!=null){
                map.put(i,map.get(i)+1);
            }else
                map.put(i,1);

            if(map.get(i)>array.length/2)
                return i;
        }

        return 0;
    }*/
}
