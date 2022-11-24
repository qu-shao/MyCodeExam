import java.util.ArrayList;

public class TencentMusic_9_26_2 {
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        // write code here
        int[] nums = new int[a.size()];
        for(int i = 0;i < a.size();i++){
            nums[i] = a.get(i);
        }
        int len = nums.length;
        int left = 0;
        int right = 0;
        int cnt = 0;
        while(right < len){
            while(right < len && nums[right] != 0)right++;
            if(right < len){
                if(left <= right - 1){
                    int tempLen = right - 1 -left + 1;
                    long[] help = new long[tempLen];
                    help[0] = nums[left];
                    for(int i = 1;i < tempLen;i++){
                        help[i] = nums[i] * help[i - 1];
                    }
                    for(int i = 0;i < tempLen;i++){
                        for(int j = i;j < tempLen;j++){
                            if(help[i] != 0 && help[j] != 0){
                                long temp = help[j] / help[i] * nums[i];
                                if(temp % (int)(Math.pow(10, x)) == 0)cnt = (cnt + 1) % (1000000000 + 7);
                            }
                        }
                    }
                }
                left = right + 1;
                while(left < len && nums[left] == 0)left++;
                if(left < len)right = left;
            }
        }
        if(left < len && nums[len - 1] != 0){
            int tempLen = len - left;
            long[] help = new long[tempLen];
            help[0] = nums[left];
            for(int i = 1;i < tempLen;i++){
                help[i] = nums[i] * help[i - 1];
            }
            for(int i = 0;i < tempLen;i++){
                for(int j = i;j < tempLen;j++){
                    if(help[i] != 0 && help[j] != 0){
                        long temp = help[j] / help[i] * nums[i];
                        if(temp % (int)(Math.pow(10, x)) == 0)cnt = (cnt + 1) % (1000000000 + 7);
                    }
                }
            }
        }
        return cnt;
    }
}
