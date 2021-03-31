/**
 * @author zr
 * @create 2021-03-31-21:33
 */

import java.util.Arrays;

/**
 * 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 */
public class NC105 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 如果目标值存在返回下标，否则返回 -1
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search (int[] nums, int target) {
        // write code here
        if(nums.length<=0)
            return -1;

        int low = 0;
        int high = nums.length-1;


        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){//要返回最左边的
                int i = mid-1;
                while(  i>=0&&nums[i]==target){
                    i--;
                }
                System.out.println(i+1);
                return i+1;
            }else if(nums[mid]>target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[]{-2,1,2};
        int search = search(a, -2);
        System.out.println(search);

    }


}
