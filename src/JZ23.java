/**
 * @author zr
 * @create 2021-04-09-8:27
 */

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * （ps：我们约定空树不是二叉搜素树）
 *
 * 输入
 * [4,8,6,12,16,14,10]
 *
 * 返回值
 * true
 */
public class JZ23 {
    public boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence==null||sequence.length==0)
            return false;


        return judge(sequence, 0, sequence.length-1);
    }

    public boolean judge(int[] a,int start ,int end){//数组 起始位置 结束位置

        if(start>=end)//边界
            return true;

        int rootVal = a[end];//后序

        int split = start;//分界点

        while (split<end&&a[split++]<rootVal){
        }

        while (split<end){
            if(a[split++]<rootVal)//右边都应该比root大
                return false;
        }

        return judge(a,start, split-1)&&judge(a,split+1, end);
    }

}
