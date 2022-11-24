import java.util.Scanner;

/**
 * @User: Qushao
 * @DateTime: 2022/9/1 19:06
 * @Description:
 **/
public class RedBook_9_4_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = Integer.MAX_VALUE;
        int[] data = new int[n];
        for(int i = 0;i < n;i++){
            data[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            int toSeven = Math.abs(7 - data[i]);
            int toFuSeven = Math.abs(-7 - data[i]);
            int[] nums = new int[n - 1];
            int index = 0;
            for(int j = 0;j < n;j++){
                if(j != i){
                    nums[index++] = data[j];
                }
            }
            int[][] dp = new int[2][n - 1];
            dp[0][0] = Math.abs(1 - nums[0]);
            dp[0][1] = Math.abs(-1 - nums[0]);
            for(int j = 1;j < n - 1;j++){
                dp[0][j] = Math.min(Math.abs(1 - nums[j]) + dp[0][j - 1], Math.abs(-1 - nums[j]) + dp[1][j - 1]);
                dp[1][j] = Math.min(Math.abs(1 - nums[j]) + dp[1][j - 1], Math.abs(-1 - nums[j]) + dp[0][j - 1]);
            }
            res = Math.min(res, Math.min(toFuSeven + dp[1][n - 2], toSeven + dp[0][n - 2]));
        }
        System.out.println(res);
    }
}