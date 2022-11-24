import java.util.*;

public class DuXiaoMan_8_31_2 {
    public static int[][] dir = {{1,0},{0,1}};
    public static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0;t < T;t++){
            set.clear();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            int[][] nums = new int[n][m];
            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    nums[i][j] = sc.nextInt();
                }
            }
            dfs(nums, 0, 0, nums[0][0]);
            if(set.contains(x)) System.out.println("yes");
            else{
                System.out.println("no");
            }
        }
    }

    public static void dfs(int[][] nums,int x,int y, int sum){
        if(x == nums.length - 1 && y == nums[0].length - 1){
            set.add(sum);
            return;
        }
        for(int i = 0;i < dir.length;i++){
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if(isValid(nums, newX, newY)){
                dfs(nums, newX, newY, sum + nums[newX][newY]);
            }
        }
    }

    public static boolean isValid(int[][] nums, int x, int y){
        int n = nums.length, m = nums[0].length;
        if( x >= n || y >= m)return false;
        return true;
    }
}
