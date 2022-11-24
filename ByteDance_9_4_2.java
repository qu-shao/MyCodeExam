import java.util.Scanner;

/**
 * @User: Qushao
 * @DateTime: 2022/9/4 19:24
 * @Description:
 **/
public class ByteDance_9_4_2 {
    public static int[][] mat;
    public static int n;
    public static int m;
    public static int res = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        mat = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        for(int i = 0;i < m;i++){
            dfs(0, i, 0);
        }
        System.out.println(res);
    }

    public static void dfs(int x, int y, int point){
        if(x == n - 1 && y >= 0 && y < m){
            if(mat[x][y] >= 0){
                point += mat[x][y];
            }
            res = Math.max(res, point);
            return;
        }
        if(y < 0 || y >= m)return;
        if(mat[x][y] == -1){
            dfs(x + 1, y - 1, point);
            dfs(x + 1, y + 1, point);
        }else{
            point += mat[x][y];
            dfs(x + 1, y, point);
        }
    }
}
