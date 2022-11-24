import java.util.Scanner;

public class Ant_9_15_3 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s = in.nextLine();
        int len = s.length();
        long res = 0L;
        for(int i = 0;i < len;i++){
            for(int j = i + 1;j <= len;j++){
                if(check(s.substring(i, j)))res++;
            }
        }
        System.out.println(res);
    }
    public static boolean check(String s){
        int[] cnt = new int[26];
        int odd = 0;
        for(int i = 0;i < s.length();i++){
            cnt[s.charAt(i) - 'a']++;
        }
        for(int el : cnt){
            if(el % 2 == 1)odd++;
        }
        return odd == 1;
    }
}
