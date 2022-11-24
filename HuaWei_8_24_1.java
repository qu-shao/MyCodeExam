import java.util.*;
public class HuaWei_8_24_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int len = s.length;
        int[] data = new int[len];
        for(int i = 0;i < len;i++){
            data[i] = Integer.parseInt(s[i]);
        }
        if(len == 1){
            System.out.println(data[0] + ",1");
            return;
        }
        Arrays.sort(data);
        int resLeft = 0;
        int resRight = -1;
        int curLeft = 0;
        for(int i = 1;i < len;i++){
            if(data[i] == data[i - 1] + 1) {
                continue;
            } else{
                if(i - 1 - curLeft > resRight - resLeft){
                    resLeft = curLeft;
                    resRight = i - 1;
                }
                curLeft = i;
            }
        }
        if(data[len - 1] == data[len - 2] + 1){
            if(len - 1 - curLeft > resRight - resLeft){
                resLeft = curLeft;
                resRight = len - 1;
            }
        }
        System.out.print(String.valueOf(data[resLeft]) + "," + String.valueOf(resRight - resLeft + 1));
    }
}
