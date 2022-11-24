import java.util.ArrayList;
import java.util.Scanner;

/**
 * @User: Qushao
 * @DateTime: 2022/8/31 17:05
 * @Description:
 **/
public class XieCheng_8_30_3 {
    public static int r, g, b;
    public static char[] colors;
    public static int res = 0;
    public static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        colors = sc.nextLine().toCharArray();
        for (char color : colors) {
            if (color == 'r') r++;
            else if (color == 'g') g++;
            else {
                b++;
            }
        }
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        dfs(1, -1);
        System.out.println(res);
    }

    public static int[] dfs(int node, int parent) {
        int[] color = new int[3];
        if (colors[node] == 'r') color[0]++;
        else if (colors[node] == 'g') color[1]++;
        else color[2]++;
        if (edges.get(node).size() == 1 && edges.get(node).get(0) == parent) {
            return color;
        }
        for (int nextNode : edges.get(node)) {
            if (nextNode != parent) add(color, dfs(nextNode, node));
        }
        if (color[0] >= 1 && color[1] >= 1 && color[2] >= 1 && r - color[0] >= 1 && g - color[1] >= 1 && b - color[2] >= 1)
            res++;
        return color;
    }

    public static void add(int[] a, int[] b) {
        for (int i = 0; i < 3; i++) {
            a[i] += b[i];
        }
    }
}
