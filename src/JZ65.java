/**
 * @author zr
 * @create 2021-05-19-20:55
 *
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e
 *
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 示例1
 * 输入
 * 复制
 * [[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcced"
 * 返回值
 * 复制
 * true
 * 示例2
 * 输入
 * 复制
 * [[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcb"
 * 返回值
 * 复制
 * false
 * 备注:
 * 0 <= matrix.length <= 200
 * 0 <= matrix[i].length <= 200
 */
public class JZ65 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix char字符型二维数组
     * @param word string字符串
     * @return bool布尔型
     */
    public boolean hasPath (char[][] matrix, String word) {
        // write code here
        for(int i=0;i<matrix.length;i++){//row
            for(int j=0;j<matrix[0].length;j++){//col
                boolean visited[][] = new boolean[matrix.length][matrix[0].length];
                if(hasPathCore(i, j, matrix, word, 0,visited))
                    return true;
            }
        }

        return false;
    }

    public boolean hasPathCore(int row,int col,char[][]matrix,String word,int index,boolean[][] visited){

        if(row<0||row>=matrix.length||col<0||col>=matrix[0].length||visited[row][col])
            return false;

        if(index==word.length()-1&&word.charAt(index)==matrix[row][col])
            return true;

        if(word.charAt(index)==matrix[row][col]){

            visited[row][col] = true;

            if(hasPathCore(row-1, col, matrix, word, index+1, visited)
                ||hasPathCore(row+1, col, matrix, word, index+1, visited)
                    ||hasPathCore(row, col-1, matrix, word, index+1, visited)
                    ||hasPathCore(row, col+1, matrix, word, index+1, visited)){
                return true;
            }else {
                visited[row][col] = false;
                return false;
            }
        }else {//当前位置就不等
            visited[row][col] = false;
            return false;
        }

    }

}
