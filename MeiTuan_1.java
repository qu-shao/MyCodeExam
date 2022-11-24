import java.util.ArrayList;
import java.util.List;

public class MeiTuan_1 {
    public static void main(String[] args) {
        int m = 2, n = 3;
        dfs(m, n, 0, 0, new ArrayList<>());
    }

    private static void dfs(int B, int G, int boy, int girl, List<Integer> res) {
        if (boy > girl) { // 男大于女，不符合，直接结束
            return;
        }
        if (B == 0 && G == 0) { // 男女剩余为0，
            if (girl >= boy) { // 女大于男，输出结果；
                System.out.println(res);
            }
        }
        if (B < 0 || G < 0) { // 任何一个小于0，直接结束
            return;
        }
        res.add(1);
        dfs(B-1, G, boy+1, girl, res);// 每次选择加入一个男孩或者女孩；
        res.remove(res.size()-1);

        res.add(0);
        dfs(B, G-1, boy, girl+1, res); // 每次选择加入一个男孩或者女孩；
        res.remove(res.size()-1);
    }
}
