import java.util.*;

public class Monkey_8_26_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        in.nextLine();
        for (int m = 0; m < M; m++) {
            String first = in.nextLine();
            String second = in.nextLine();
            String[] dataMeta = second.split(" ");
            int K = Integer.parseInt(first.split(" ")[0]);
            HashMap<Integer, Integer> target = find(K);
            int N = Integer.parseInt(first.split(" ")[1]);
            int[] data = new int[N];
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(dataMeta[i]);
            }
            HashMap<Integer, Integer> cur = new HashMap<>();
            int res = 0;
            HashSet<Integer> hs = new HashSet<>();
            for (int el : data) {
                hs.add(el);
            }
            boolean can = true;
            if (data.length < target.size()) {
                can = false;
            }
            if (can) {
                for (int el : target.keySet()) {
                    if (!hs.contains(el)) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    int l = 0, r = 0;
                    while (r < N) {
                        if (check(cur, target)) {
                            res = res == 0 ? r - l : Math.min(res, r - l);
                            cur.replace(data[l], cur.get(data[l]) - 1);
                            l++;
                        } else {
                            if (cur.containsKey(data[r])) {
                                cur.replace(data[r], cur.get(data[r]) + 1);
                            } else {
                                cur.put(data[r], 1);
                            }
                            r++;
                        }
                    }
                    if (check(cur, target)) {
                        res = res == 0 ? r - l : Math.min(res, r - l);
                    }
                }
            }
            System.out.println(res);
        }
    }

    public static HashMap<Integer, Integer> find(int i) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (i > 1) {
            int j = 2;
            while (i % j != 0) {
                j++;
            }
            temp.add(j);
            i /= j;
        }
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int el : temp) {
            if (res.containsKey(el)) {
                res.replace(el, res.get(el) + 1);
            } else {
                res.put(el, 1);
            }
        }
        return res;
    }

    public static boolean check(HashMap<Integer, Integer> cur, HashMap<Integer, Integer> target) {
        for (int key : target.keySet()) {
            if (cur.containsKey(key) && cur.get(key) >= target.get(key)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}