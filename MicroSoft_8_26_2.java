public class MicroSoft_8_26_2 {
    public static void main(String[] args) {

    }
    public static int solution(int[] A, int M) {
        // write your code in Java 11 (Java SE 11)
        boolean[] visited = new boolean[A.length];
        int res = 0;
        for(int i = 0;i < A.length;i++){
            if(!visited[i]){
                int temp = 1;
                for(int j = i + 1;j < A.length;j++){
                    if(Math.abs(A[j] - A[i]) % M == 0){
                        temp++;
                        visited[j] = true;
                    }
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }
}
