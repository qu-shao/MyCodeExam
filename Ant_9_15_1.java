import java.util.Scanner;

public class Ant_9_15_1 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int x = in.nextInt();
        String s = Integer.toBinaryString(x);
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1;i >= 0;i--){
            if(s.charAt(i) == '1'){
                sb.append((char)('a' + s.length() - 1 - i));
            }
        }
        System.out.println(sb.toString());
    }
}
