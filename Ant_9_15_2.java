import java.util.Scanner;

public class Ant_9_15_2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        Long res = 0L;
        for(int n = 0;n < N;n++){
            int a = in.nextInt();
            int b = in.nextInt();
            res += Math.abs(a - b);
        }
        System.out.println(res);
    }
}
