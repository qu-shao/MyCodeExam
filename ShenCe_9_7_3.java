import java.util.Scanner;

public class ShenCe_9_7_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = in.nextInt();
        }
        int max = nums[0];
        int res = -1;
        for(int i = 1;i < n;i++){
            res = Math.max(res, nums[i] - i + max);
            max = Math.max(max, nums[i] + i);
        }
        System.out.println(res);
    }
}
