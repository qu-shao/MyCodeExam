import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RedBook_8_28_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] data = new int[n];
        long res = 0;
        for(int i = 0;i < n;i++){
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        for(int i = 0;i < n - 1;i++){
            for(int j = i + 1;j < n;j++){
                if(data[i] * data[j] >= k){
                    res += n - j;
                    break;
                }
            }
        }
        System.out.println(res * 2);
    }
}
