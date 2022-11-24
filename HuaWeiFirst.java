import java.util.HashMap;

public class HuaWeiFirst {
    public static void main(String[] args) {
        String s = "ABSASSASASBASccddqabcndfg";
        System.out.println(longest(s));
    }

    public static int longest(String s){
        int len = s.length();
        if(len <= 1)return len;
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int res = 0;
        for(int i = 0;i < len;i++){
            if(hm.containsKey(s.charAt(i))){
                left = Math.max(left, hm.get(s.charAt(i)) + 1);
            }
            hm.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
