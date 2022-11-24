import java.util.ArrayList;
import java.util.Scanner;

public class DuXiaoMan_8_31_3 {
    public static long mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> res = new ArrayList<>();
        res.add(1L);
        res.add(9L);
        res.add(80L);
        for(int i = 3;i <= n;i++){
            long temp = res.get(i - 1) * 8 + res.get(i - 3) * 64;
            temp = temp % mod;
            res.add(temp);
        }
        long ans = res.get(n) % mod;
        System.out.println(ans);
    }
}
