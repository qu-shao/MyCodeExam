public class HuaWeiSecond {
    public static void main(String[] args) {
        String s = "aaaaaa";
        System.out.println(zip(s));
    }
    public static String zip(String s) {
        if (null == s) return null;
        int len = s.length();
        if (len <= 1) return s;
        char cur = s.charAt(0);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != cur) {
                sb.append(cur).append(cnt);
                cur = s.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        sb.append(cur).append(cnt);
        String res = sb.toString();
        if (res.length() < len) {
            return res;
        } else {
            return s;
        }
    }
}
