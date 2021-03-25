import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author zr
 * @create 2021-03-21-15:32
 */
public class XiaoHongShu {
    /**
     *  某小红薯在小红书的活动中抽奖中了一定价值的薯券，这些薯券可以用来购买一批商品，求有多少种购买组合。其中一件商品可以买多件。
     * 输 入:薯券金额、商品分别价格
     * 输出 :组合数
     *
     * 输入薯券金额、商品分别价格
     * 例如：10 [2,3,5]
     * 10与[2,3,5]中间有空格
     *
     * 输出4，则结果集可以为:2,2,2,2,2；5,5；2,3,5；2,2,3,3共有4种组合
     */

    @Test
    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        String next = scanner.next();
        int length = next.length();
        String subString = next.substring(1,length-1);
        String[] split = subString.split(",");
        int[] prices = new int[split.length];
        for(int i = 0;i < split.length;i++){
            prices[i] = Integer.parseInt(split[i]);
        }

        //定义dp[][]存储组合数
        int[][] dp = new int[prices.length+1][sum+1];

        //初始状态，在金额为零的情况下，什么都不选
        for(int i = 0;i < dp.length;i++){
            dp[i][0] = 1;
        }


        for(int i=1;i<prices.length+1;i++){//表格行索引
            for(int j=1;j<sum+1;j++){//容量
                if(j>=prices[i-1]){//价格表从0索引开始
                    //能放下
                    //组合数为 选 + 不选
                    dp[i][j] = dp[i][j-prices[i-1]] + dp[i-1][j];
                }else{
                    //如果当前的金额大于总金额，不可以选择
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[prices.length][sum]);
    }


    /**
     *  薯队长写了一篇笔记草稿，请你帮忙输出最后内容。
     *  1.输入字符包括，"("    ,    ")"    和    "<"和其他字符。
     * 2.其他字符表示笔记内容。
     *  3.()之间表示注释内容，任何字符都无效。    括号保证成对出现。
     *  4."<"表示退格,    删去前面一个笔记内容字符。括号不受"<"影响    。
     *
     *  Corona(Trump)USA<<<Virus
     */
    @Test
    public  void test2(){
        /*Scanner scanner = new Scanner(System.in);
        String str = scanner.next();*/

        String str = new String("Corona(Trump)USA<<<Virus");
        char[] chars = str.toCharArray();

        String result = "";
        int count = 0;

        for(int i=0;i<chars.length;i++){
            if (chars[i] == '('){
                count++;
            }else if(chars[i] ==')'){
                count--;
            }else if(chars[i] == '<'){
                result = result.substring(0, result.length()-1);
            }else {
                if(count==0)
                    result += chars[i];
            }
        }

        System.out.println(result);
    }
}
