/**
 * @author zr
 * @create 2021-03-19-18:11
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 set(key, value)：将记录(key, value)插入该结构
 get(key)：返回key对应的value值
 [要求]
 set和get方法的时间复杂度为O(1)
 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 若opt=1，接下来两个整数x, y，表示set(x, y)
 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 对于每个操作2，输出一个答案
 */
public class NC93 {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */

    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private int k;

    /**
     * 双向链表
     */
    class Node{
        int key,val;
        Node pre,next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }


    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.k = k;
        head.next = tail;
        tail.pre = head;

        //有几行2开头的
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int result[] = new int[len];

        int lines = operators.length;
        int cols = operators[0].length;
        int j = 0;
        for(int i=0;i<lines;i++){
            if(operators[i][0]==1){//set
                set(operators[i][1],operators[i][2]);
            }else{//get
                result[j++] = get(operators[i][1]);
            }
        }

        return result;
    }

    public void set(int key,int val){
        if(get(key)!=-1) {
            Node node = map.get(key);
            node.val = val;//更新值
            //把他从当前位置卸下
            if(node.pre!=head){
                node.pre.next = node.next;
                node.next.pre = node.pre;
                connectToHead(node);
            }
        }
        else{
            if(map.size()==k){//移除最久未使用的
                int remove = tail.pre.key;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                map.remove(remove);
            }
            Node node = new Node(key, val);
            map.put(key, node);
            connectToHead(node);
        }

    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            //把他从当前位置卸下
            if(node.pre!=head){
                node.pre.next = node.next;
                node.next.pre = node.pre;
                connectToHead(node);
            }
            return node.val;

        }
        return -1;
    }

    public void connectToHead(Node node){//从后往前 先右后左
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
}
