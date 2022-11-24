import java.util.Scanner;
public class Netease_8_26_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0;t < T;t++){
            int cnt = in.nextInt();
            in.nextLine();
            square[] data = new square[cnt];
            for(int i = 0;i < cnt;i++){
                int x1 = in.nextInt();
                int y1 = in.nextInt();
                int x2 = in.nextInt();
                int y2 = in.nextInt();
                square temp = new square(x1, y1, x2, y2);
                data[i] = temp;
            }
            boolean[] visited = new boolean[cnt];
            long res = 0;
            for(int j = 0;j < cnt;j++){
                if(visited[j] == true)continue;
                for(int k = j + 1;k < cnt;k++){
                    if(visited[k] == true)continue;
                    else{
                        if(isOverlap(data[j], data[k])){
                            res += cal(data[j], data[k]);
                            visited[k] = true;
                            break;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }

    public static boolean isOverlap(square sq1, square sq2){
        return (Math.min(sq1.x2, sq2.x2) > Math.max(sq1.x1, sq2.x1) &&
                Math.min(sq1.y2, sq2.y2) > Math.max(sq1.y1, sq2.y1));
    }
    public static int cal(square sq1, square sq2){
        int totalS = Math.abs(sq1.x1 - sq1.x2) * Math.abs(sq1.y1 - sq1.y2) + Math.abs(sq2.x1 - sq2.x2)
                * Math.abs(sq2.y1 - sq2.y2);
        int m = Math.min(sq1.y2, sq2.y2) - Math.max(sq1.y1, sq2.y1);
        int n = Math.min(sq1.x2, sq2.x2) - Math.max(sq1.x1, sq2.x1);
        int over = Math.max(0, m) * Math.max(0, n);
        return totalS - over;
    }
}
class square{
    int x1;
    int y1;
    int x2;
    int y2;

    public square(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
