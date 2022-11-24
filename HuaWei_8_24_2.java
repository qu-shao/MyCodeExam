import java.util.*;

public class HuaWei_8_24_2 {
    public static TreeSet<String> res = new TreeSet<>();
    public static HashMap<String, HashSet<String>> edges = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> element = new HashSet<>();
        int len = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < len; i++) {
            String s = sc.nextLine();
            String from = s.split(">")[0];
            String to = s.split(">")[1];
            element.add(from);
            element.add(to);
            if (edges.containsKey(from)) {
                edges.get(from).add(to);
            } else {
                HashSet<String> hs = new HashSet<>();
                hs.add(to);
                edges.put(from, hs);
            }
        }
        for (String el : element) {
            if (!edges.containsKey(el)) {
                continue;
            } else {
                Queue<String> help = new LinkedList();
                HashSet<String> vistited = new HashSet<>();
                boolean stop = false;
                help.add(el);
                while (!help.isEmpty() && !stop) {
                    String cur = help.poll();
                    HashSet<String> depends = edges.get(cur);
                    if (edges.containsKey(cur)) {
                        for (String depend : depends) {
                            if (!vistited.contains(depend)) {
                                help.add(depend);
                                vistited.add(depend);
                            }
                            if (depend.equals(el)) {
                                res.add(el);
                                stop = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            System.out.println("NA");
            return;
        }
        StringBuilder result = new StringBuilder();
        for (String el : res) {
            result.append(el + " ");
        }
        System.out.println(result.toString().trim());
    }
}
