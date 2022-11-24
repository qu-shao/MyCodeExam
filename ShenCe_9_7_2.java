import java.lang.reflect.Array;
import java.util.*;

public class ShenCe_9_7_2 {
    public static HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
    public static void main(String[] args) {
        int res = 1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i < n;i++){
            int key = sc.nextInt();
            int value = sc.nextInt();
            if(edges.containsKey(key)){
                edges.get(key).add(value);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(value);
                edges.put(key, temp);
            }
        }
        HashSet<Integer> path = new HashSet<>();
        int one = sc.nextInt();
        int two = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        q.offer(one);
        while(!q.isEmpty()){
            int cur  = q.poll();
            if(cur == 1)break;
            else{
                path.add(cur);
                if(edges.containsKey(cur)){
                    for(int el : edges.get(cur)){
                        q.offer(el);
                    }
                }
            }
        }
        q.clear();
        q.offer(two);
        while(!q.isEmpty()){
            int cur  = q.poll();
            if(path.contains(cur)){
                res = cur;
                break;
            }
            else{
                path.add(cur);
                if(edges.containsKey(cur)){
                    for(int el : edges.get(cur)){
                        q.offer(el);
                    }
                }
            }
        }
        System.out.println(res);
    }
}
