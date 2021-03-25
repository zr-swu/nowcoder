/**
 * @author zr
 * @create 2021-03-18-21:59
 */
public class JZ6 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    public int minNumberInRotateArray(int [] array) {

        if(array.length==0)
            return 0;

        /*int left = 0;
        int right = array.length-1;

        int middle = 0;

        while (left<right){//正常情况下最左边比最右边大  ： 456123

            if(array[left] <= array[right])//说明left就是最小点
                return array[left];


            middle = (left+right)/2;

            if(array[middle]<array[right]){//只能和右边比  和左边比不确定
                right = middle;//在左侧找 middle可能为最小 不能=middle-1
            }
            else if(array[middle]>array[right]){
                left = middle+1;//在右侧找 middle不可能为最小 直接从下一个开始
            }else{//array[middle]==array[right]
                --right;
            }
        }//退出循环即 left>=right*/

        for(int i=0;i<array.length;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }

        }
        return array[0];
    }

}
