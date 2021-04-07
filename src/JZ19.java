/**
 * @author zr
 * @create 2021-04-07-22:03
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1  2  3  4
 *                             5  6  7  8
 *                             9 10 11 12
 *                             13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 示例1
 * 输入
 * [[1,2],[3,4]]
 *
 * 返回值
 * [1,2,4,3]
 */
public class JZ19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {


        ArrayList<Integer> result = new ArrayList<>();

        if(matrix==null|| matrix.length == 0 || matrix[0].length == 0)
            return result;



        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (true){
            for(int i=left;i<=right;i++){//最上面一行 right也取
                result.add(matrix[up][i]);
            }

            up++;//向下逼近

            if(up>down)//up跑到down下面le
                break;

            for(int i=up;i<=down;i++){
                result.add(matrix[i][right]);
            }

            right--;
            if(left>right)
                break;


            for(int i=right;i>=left;i--){
                result.add(matrix[down][i]);
            }

            down--;
            if(up>down)
                break;

            for(int i=down;i>=up;i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if(left>right)
                break;
        }

        return result;
    }

    @Test
    public void test (){
        int [][] a = {{1,2},{3,4}};
        ArrayList<Integer> list = printMatrix(a);
        list.stream().forEach(System.out::println);
    }
}
