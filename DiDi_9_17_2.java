import java.util.Scanner;

public class DiDi_9_17_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[1000];
        int[] b = new int[1000];
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            left[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            right[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        for(int i = 0;i < n;i++){
            if(nums[i] == 1){
                a[left[i]]++;
                a[right[i] + 1]--;
            }else{
                b[left[i]]++;
                b[right[i] + 1]--;
            }
        }
        int ans = 0;
        int cnt_a = 0, cnt_b = 0;
        for(int i = 0;i < a.length;i++){
            cnt_a += a[i];
            cnt_b += b[i];
            if(cnt_a >= p && cnt_b >= q)ans++;
        }
        System.out.println(ans);
    }
}
