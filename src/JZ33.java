/**
 * @author zr
 * @create 2021-04-14-22:14
 */

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
 * 因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 示例1
 * 输入
 * 7
 * 返回值
 * 8
 */
public class JZ33 {
    public int GetUglyNumber_Solution(int index) {

        if(index<7)
            return index;

        int _2=0,_3=0,_5=0;
        int []num = new int[index];

        num[0] = 1; //第一个丑数是1

        for(int i=1;i<index;i++){
            num[i] = Math.min(num[_2]*2,Math.min(num[_3]*3,num[_5]*5));

            if(num[i] == num[_2]*2)
                _2++;

            if(num[i] == num[_3]*3)
                _3++;

            if(num[i] == num[_5]*5)
                _5++;

        }

        return num[index-1];
    }

}
