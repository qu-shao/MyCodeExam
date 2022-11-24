import java.util.*;

public class Goldon_8_31_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[M][3];
        int res = 0;
        int ruled = 0;
        for(int i = 0;i < M;i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            nums[i][2] = sc.nextInt();
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
        List<int[]> merged = new ArrayList<>();
        for(int i = 0;i < M;i++){
            int L = nums[i][0], R = nums[i][1];
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L, R});
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        for(int[] el : merged){
            ruled += el[1] - el[0] + 1;
        }
        res = N - ruled;
        int lastIndex = -1;
        for(int i = 0;i < M;i++){
            if(lastIndex > nums[i][1])continue;
            if(nums[i][0] > lastIndex){
                res += nums[i][2];
                lastIndex = nums[i][1] + 1;
            }else{
                if(lastIndex + nums[i][2] - 1 <= nums[i][1]){
                    res += nums[i][2];
                }else{
                    res += nums[i][1] - lastIndex + 1;
                }
                lastIndex = nums[i][1] + 1;
            }
        }
        System.out.println(res);
    }
}
