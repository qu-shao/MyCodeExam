import java.util.ArrayList;
import java.util.Scanner;

public class ByteDance_9_18_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mount = 0;
        ArrayList[] data = new ArrayList[n];
        for(int i = n - 1;i >= 0;i--){
            int m = sc.nextInt();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0;j < m;j++){
                temp.add(sc.nextInt());
                mount++;
            }
            data[i] = temp;
        }
        int res = 0;
        for(int i = n - 1;i >= 1;i++){

        }
        System.out.println();
    }
}
