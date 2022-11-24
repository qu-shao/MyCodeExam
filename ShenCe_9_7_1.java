import java.util.*;

public class ShenCe_9_7_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Long res = 0L;
            boolean isValid = true;
            String s = in.nextLine();
            if (s.startsWith(".") || s.endsWith(".")) {
                isValid = false;
            }
            for (int i = 0; i < s.length() && isValid; i++) {
                if (!(s.charAt(i) <= '9' && s.charAt(i) >= '0' || s.charAt(i) == '.')) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                String[] help = s.split("\\.");
                int[] temp = new int[7];
                if (help.length != 7) {
                    isValid = false;
                } else {
                    for (int i = 0; i < 7; i++) {
                        if (help[i].isEmpty() || help[i].length() == 1 && help[i].charAt(0) == '0') temp[i] = 0;
                        else {
                            if (help[i].startsWith("0")) {
                                isValid = false;
                                break;
                            }
                            temp[i] = Integer.parseInt(help[i]);
                            if (!(temp[i] >= 0 && temp[i] <= 255)) {
                                isValid = false;
                                break;
                            }
                        }
                    }
                }
                if (!isValid) {
                    System.out.println("-1");
                } else {
                    for (int i = 0; i < 7; i++) {
                        res = res << 8;
                        res += temp[i];
                    }
                    System.out.println(res);
                }
            } else {
                System.out.println("-1");
            }
        }
    }
}
