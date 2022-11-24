import java.util.*;
public class MicroSoft_8_26_1 {
    public int solution(String S) {
        // write your code in Java 11 (Java SE 11)
        int n = S.length();
        int[] presum = new int[n];
        int sum = 0;
        for(int i = 0;i < n;i++){
            int c = 1<<(S.charAt(i) - 'a');
            sum ^= c;
            presum[i] = sum;
        }
        int max = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for(int i = 0;i < n;i++){
            int x = presum[i];
            if(mp.containsKey(x)){
                max = Math.max(max, i - mp.get(x));
            }else{
                mp.put(x, i);
            }
        }
        return max;
    }
}
