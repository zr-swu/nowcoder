/**
 * @author zr
 * @create 2021-05-19-21:25
 */

/**
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 返回值描述:
 * 输出答案。
 *
 * 示例1
 * 输入
 * 8
 *
 * 返回值
 * 18
 *
 * dp[j] =  max(j * dp[i-j])
 */
public class JZ67 {
   /* public int cutRope(int target) {
        if(target==2)
            return 1;
        if (target==3)
            return 2;

        int dp[] = new int[target+1];

        //如果绳子小于4,不再切割直接计算长度,因为绳子的原始长度大于切割后的乘积
        //既然这样 就不分 保持原长
        for(int i=1;i<=4;i++){
            dp[i] = i ;
        }


        int max = 0;
        for(int i=5;i<=target;i++){
            max = 0;
            for(int j=1;j<=i/2;j++){//减绳子 长度为i 减掉j
                max = Math.max(max, j*dp[i-j]);
                dp[i] = max;
            }
        }

        return dp[target];
    }*/

    public int cutRope(int target){
        if(target == 1)
            return 0;
        if(target == 2)
            return 1;
        if(target == 3)
            return 2;

        int dp[] = new int[target+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i=4;i<=target;i++){
            int max = 0;
            for(int j =1 ; j<=i/2;j++){
                max = Math.max(max, j * dp[i-j]);
                dp[i] = max;
            }
        }

        return dp[target];
    }
}
