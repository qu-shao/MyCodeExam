import java.util.Scanner;

public class DuXiaoMan_8_31_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int beishu = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0;i < len;i++){
            nums[i] = sc.nextInt();
        }
        int[][] max = new int[len][len];
        int[][] min = new int[len][len];
        for(int i = 0;i < len;i++){
            max[i][i] = nums[i];
            min[i][i] = nums[i];
        }
        for(int i = 0;i < len;i++){
            for(int j = i + 1;j < len;j++){
                max[i][j] = Math.max(max[i][j - 1], nums[j]);
                min[i][j] = Math.min(min[i][j - 1], nums[j]);
            }
        }
        int res = 0;
        for(int i = 0;i < len;i++){
            for(int j = i;j < len;j++){
                if(max[i][j] == beishu * min[i][j])res++;
            }
        }
        System.out.println(res);
    }
}
