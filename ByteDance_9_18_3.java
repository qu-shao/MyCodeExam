import java.util.Scanner;

public class ByteDance_9_18_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        if(len <= 2){
            System.out.println(0);
            return;
        }
        int res = 0;
        int index = -1;
        int cur = 0;
        while(cur < len - 1){
            while(cur < len - 1 && s.charAt(cur) != s.charAt(cur + 1)){
                cur++;
            }
            res = Math.max(res, cur - index);
            index = cur;
            cur++;
        }
        if(s.charAt(len - 1) != s.charAt(len - 2)){
            res = Math.max(res, len - 1 - index);
        }
        if(res <= 2)res = 0;
        System.out.println(res);
    }
}
