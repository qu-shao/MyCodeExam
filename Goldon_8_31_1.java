import java.util.HashMap;
import java.util.Scanner;

public class Goldon_8_31_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        int[] s = new int[n];
        int[] e = new int[n];
        HashMap<Integer, Integer> start = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();
        for(int i = 0;i < n;i++){
            s[i] = sc.nextInt();
            start.put(s[i], i);
        }
        for(int i = 0;i < n;i++){
            e[i] = sc.nextInt();
            end.put(e[i], i);
        }
        for(int i = 0;i < n;i++){
            int t = start.get(e[i]);
            boolean flag = false;
            for(int j = t - 1;j >= 0;j--){
                if(i < end.get(s[j])){
                    flag = true;
                    break;
                }
            }
            if(flag)res++;
        }
        System.out.println(res);
    }
}
