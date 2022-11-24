import java.util.Scanner;

public class JingDong_9_9_2 {
    public static final int MOD = 1000000000 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        double res = 0;
        int ji = 0;
        int ou = 0;
        for(int el : nums){
            if(el % 2 == 0){
                ou++;
            }else{
                ji++;
            }
        }
        res = fastPow(2, ji) - 1 - ji;
        res = res + fastPow(2, ou) - 1 - ou;
        System.out.println((int)(res % MOD));
    }

    public static long fastPow(long a, int n){
        long ans = 1;
        a = a % MOD;
        while(n != 0){
            if((n & 1) != 0){
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            n >>= 1;
        }
        return ans;
    }
}
