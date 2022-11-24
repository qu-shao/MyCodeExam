import java.net.Inet4Address;
import java.util.HashSet;

public class MicroSoft_8_26_3 {
    public static void main(String[] args) {

    }
    public static int solution(int[] A, int[] B) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i < A.length;i++){
            hs.add(Math.max(A[i], B[i]));
        }
        for(int i = 1;i <= A.length + 1;i++){
            if(!hs.contains(i))return i;
        }
        return 0;
    }
}
