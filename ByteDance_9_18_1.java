import java.util.Scanner;

public class ByteDance_9_18_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] sArr = s.split(",");
        long[] nums = new long[sArr.length];
        int len = nums.length;
        for(int i = 0;i < len;i++){
            nums[i] = Long.parseLong(sArr[i].trim());
        }
        StringBuilder sb = new StringBuilder();
        if(len <= 2){
            for(long el : nums){
                sb.append(el + ",");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
            return;
        }
        int last = 0;
        int cur = 0;
        while(cur < len - 1){
            while(cur < len - 1 && nums[cur] == nums[cur + 1] - 1){
                cur++;
            }
            if(nums[cur] - nums[last] >= 2){
                sb.append(nums[last] + "-" + nums[cur] + ",");
            }else{
                for(int i = last;i <= cur;i++){
                    sb.append(nums[i] + ",");
                }
            }
            cur++;
            last = cur;
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
