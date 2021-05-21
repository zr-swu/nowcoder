/**
 * @author zr
 * @create 2021-05-21-20:10
 */


import javafx.beans.NamedArg;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 地上有一个rows行和cols列的方格。坐标从 [0,0] 到 [rows-1,cols-1]。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于threshold的格子。
 * 例如，当threshold为18时，机器人能够进入方格[35,37]，因为3+5+3+7 = 18。
 * 但是，它不能进入方格[35,38]，因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * <p>
 * 范围:
 * 1 <= rows, cols<= 100
 * 0 <= threshold <= 20
 * <p>
 * 示例1
 * 输入
 * 复制
 * 1,2,3
 * 返回值
 * 复制
 * 3
 * <p>
 * 示例2
 * 输入
 * 复制
 * 0,1,3
 * 返回值
 * 复制
 * 1
 * <p>
 * 示例3
 * 输入
 * 复制
 * 10,1,100
 * 返回值
 * 复制
 * 29
 * 说明
 * [0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[0,6],[0,7],[0,8],[0,9],[0,10],[0,11],[0,12],[0,13],[0,14],[0,15],[0,16],[0,17],[0,18],[0,19],[0,20],[0,21],[0,22],[0,23],[0,24],[0,25],[0,26],[0,27],[0,28] 这29种，后面的[0,29],[0,30]以及[0,31]等等是无法到达的
 * <p>
 * <p>
 * 示例4
 * 输入
 * 复制
 * 5,10,10
 * 返回值
 * 复制
 * 21
 */
public class JZ66 {

    public class Pair<K, V> {

        private K key;

        public K getKey() {
            return key;
        }

        private V value;

        public V getValue() {
            return value;
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public int result;

    {
        result = 0;
    }

    public int movingCount(int threshold, int rows, int cols) {

        if (threshold < 0 || threshold > 20)
            return -1;

        if (rows < 1 || rows > 100 || cols < 1 || cols > 100)
            return -1;


        int[][] visited = new int[rows][cols];


//        dfs(threshold, rows, cols, 0,0,visited);
        bfs(threshold, rows, cols, visited);

        return result;
    }

    public void dfs(int threshold, int rows, int cols, int row, int col, int[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] == 1)
            return;

        if (getSum(row) + getSum(col) > threshold)
            return;

        visited[row][col] = 1;

        result += 1;


        //右下左上
        dfs(threshold, rows, cols, row, col + 1, visited);
        dfs(threshold, rows, cols, row + 1, col, visited);
        dfs(threshold, rows, cols, row, col - 1, visited);
        dfs(threshold, rows, cols, row - 1, col, visited);

    }

    public void bfs(int threshold, int rows, int cols, int[][] visited) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(0, 0));

        visited[0][0] = 1;

        while (!queue.isEmpty()) {

            Pair<Integer, Integer> poll = queue.poll();
            result++;

            if (poll.getKey() >= 0 && poll.getKey() < rows && poll.getValue() + 1 >= 0 && poll.getValue() + 1 < cols && visited[poll.getKey()][poll.getValue() + 1] != 1) {
                if(getSum(poll.getKey())+getSum(poll.getValue() + 1)<=threshold){
                    queue.add(new Pair<>(poll.getKey(), poll.getValue() + 1));
                    visited[poll.getKey()][poll.getValue() + 1] = 1;
                }
            }

            if (poll.getKey()+1 >= 0 && poll.getKey()+1 < rows && poll.getValue()  >= 0 && poll.getValue() < cols && visited[poll.getKey()+1][poll.getValue() ] != 1) {
                if(getSum(poll.getKey()+1)+getSum(poll.getValue())<=threshold){
                    queue.add(new Pair<>(poll.getKey()+1, poll.getValue()));
                    visited[poll.getKey()+1][poll.getValue() ] = 1;
                }
            }

            if(poll.getKey()>=0&&poll.getKey()<rows&&poll.getValue()-1>=0&&poll.getValue()-1<cols&&visited[poll.getKey()][poll.getValue()-1]!=1){
                if(getSum(poll.getKey())+getSum(poll.getValue()-1)<=threshold){
                    queue.add(new Pair<>(poll.getKey(), poll.getValue()-1));
                    visited[poll.getKey()][poll.getValue()-1]=1;
                }
            }

            if(poll.getKey()-1>=0&&poll.getKey()-1<rows&&poll.getValue()>=0&&poll.getValue()<cols&&visited[poll.getKey()-1][poll.getValue()]!=1){
                if(getSum(poll.getKey()-1)+getSum(poll.getValue())<=threshold){
                    queue.add(new Pair<>(poll.getKey()-1, poll.getValue()));
                    visited[poll.getKey()-1][poll.getValue()]=1;
                }
            }


        }
    }

    public int getSum(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    @Test
    public void test() {
        int i = movingCount(1, 2, 3);
        System.out.println(i);
    }
}
