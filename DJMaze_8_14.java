import java.util.*;



public class DJMaze_8_14 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param:  maze int整型二维数组 迷宫数据 固定为4x4的二维数组，0表示路，可走；1 表示墙，不可通过； 8 表示礼物，是我们的目标
     * @return: Point类ArrayList
     */
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int[][] data = {{0,1,1,1},{0,0,0,1},{1,0,8,1},{1,0,1,1}};
        ArrayList<Point> res = winMazeGift(data);
        for(Point point : res){
            System.out.println(point.x);
            System.out.println(point.y);
        }
    }
    public static boolean canFind;
    public static ArrayList<Point> winMazeGift(int[][] maze) {
        // write code here
        int row = maze.length;
        int col = maze[0].length;
        int minLen = Integer.MAX_VALUE;
        ArrayList<Point> res = new ArrayList<>();
        HashSet<Point> hs = new HashSet<>();
        for (int i = 0; i < col; i++) {
            if (maze[0][i] == 0) {
                Point point = new Point(0, i);
                hs.add(point);
            }
        }
        for (int i = 0; i < col; i++) {
            if (maze[row - 1][i] == 0) {
                Point point = new Point(row - 1, i);
                hs.add(point);
            }
        }
        for (int i = 0; i < col; i++) {
            if (maze[i][0] == 0) {
                Point point = new Point(i, 0);
                hs.add(point);
            }
        }
        for (int i = 0; i < col; i++) {
            if (maze[i][col - 1] == 0) {
                Point point = new Point(i, col - 1);
                hs.add(point);
            }
        }

        for (Point point : hs) {
            int x = point.x;
            int y = point.y;
            boolean[][] visited = new boolean[row][col];
            ArrayList<Point> path = new ArrayList<>();
            canFind = false;
            path.add(point);
            dfs(x, y, visited, maze, path);
            if (canFind) {
                if (path.size() != 0 && path.size() < minLen) {
                    minLen = path.size();
                    res = path;
                }
            }
        }
        return res;
    }

    public static boolean inArr(int[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length);
    }

    public static void dfs(int x, int y, boolean[][] visited, int[][] maze,
                           ArrayList<Point> path) {
        if(canFind)return;
        if (maze[x][y] == 8) {
            canFind = true;
            return;
        }
        int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i], nextY = y + dy[i];
            if (inArr(maze, nextX, nextY) && maze[nextX][nextY] != 1 &&
                    !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                Point point = new Point(nextX, nextY);
                path.add(point);
                dfs(nextX, nextY, visited, maze, path);
                if(canFind)break;
                visited[nextX][nextY] = false;
                path.remove(point);
            }
        }
    }
}