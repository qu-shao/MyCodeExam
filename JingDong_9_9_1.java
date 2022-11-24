import java.util.Scanner;

public class JingDong_9_9_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 0;
        int len = s.length();
        int last = 0;
        for(int i = 1;i < len;i++){
            if(s.charAt(i) == s.charAt(last)){
                continue;
            }else{
                res += process(i - last);
                last = i;
            }
        }
        res += process(len - last);
        System.out.println(res);
    }
    public static int process(int n){
        if(n <= 1)return 0;
        if(n % 3 == 0 || n % 3 == 1)return n / 3;
        return n / 3 + 1;
    }
}
