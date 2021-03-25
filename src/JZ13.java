/**
 * @author zr
 * @create 2021-03-15-21:58
 */
public class JZ13 {
    /**
     *
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    /*public int[] reOrderArray (int[] array) {//会乱序
        // write code here
        if(null == array)
            return null;
        int len = array.length;

        int head = 0;
        int tail = len-1;

        while(head<tail){
            //直到指向偶数
            while (head<tail && (array[head]&1)!=0 ){
                head++;
            }

            //直到指向奇数
            while (head<tail && (array[tail]&1)==0){
                tail--;
            }

            if (head < tail){//说明是因为 head指向偶数 tail指向奇数退出的循环
                int tmp = array[head];
                array[head] = array[tail];
                array[tail] =tmp;
            }

        }
        return  array;
    }*/
    public int[] reOrderArray (int[] array) {
        int len = array.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1-i;j++){
                if(array[j]%2==0 && array[j+1]%2!=0){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return  array;
    }
}
