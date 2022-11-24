import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RedBook_8_28_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int id = sc.nextInt();
        int[][] data = new int[n][2];
        for(int i = 0;i < n;i++){
            int temp = 0;
            for(int j = 0;j < m;j++){
                temp += sc.nextInt();
            }
            data[i][0] = i;
            data[i][1] = temp;
        }

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else{
                    return o2[1] - o1[1];
                }
            }
        });
        for(int i = 0;i < n;i++){
            if(data[i][0] == id - 1){
                System.out.println(i + 1);
                return;
            }
        }
    }
}
