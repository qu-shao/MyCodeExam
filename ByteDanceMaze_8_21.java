import java.util.Scanner;

public class ByteDanceMaze_8_21 {
    public static int outX;
    public static int outY;
    public static boolean[][] can;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int res = 0;
        can = new boolean[n][m];
        sc.nextLine();
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'O') {
                    outX = i;
                    outY = j;
                }
                maze[i][j] = s.charAt(j);
            }
        }
        dfs(outX, outY, maze);
        for (boolean[] array : can) {
            for (boolean el : array) {
                if (!el) res++;
            }
        }
        System.out.println(res);
    }

    public static boolean inArr(char[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length);
    }

    public static void dfs(int x, int y, char[][] maze) {
        can[x][y] = true;
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];
            if (inArr(maze, nextX, nextY) && !can[nextX][nextY] && (maze[nextX][nextY] == '.' || maze[nextX][nextY] == 'O')) {
                dfs(nextX, nextY, maze);
            }else if (inArr(maze, nextX, nextY) && !can[nextX][nextY] && maze[nextX][nextY] == 'L' && i == 3) {
                dfs(nextX, nextY, maze);
            }else if (inArr(maze, nextX, nextY) && !can[nextX][nextY] && maze[nextX][nextY] == 'R' && i == 2) {
                dfs(nextX, nextY, maze);
            }else if (inArr(maze, nextX, nextY) && !can[nextX][nextY] && maze[nextX][nextY] == 'U' && i == 1) {
                dfs(nextX, nextY, maze);
            }else if (inArr(maze, nextX, nextY) && !can[nextX][nextY] && maze[nextX][nextY] == 'D' && i == 0) {
                dfs(nextX, nextY, maze);
            }
        }
    }
}
