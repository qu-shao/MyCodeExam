import java.util.Scanner;

public class ByteDance_9_18_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int target = len / 4;
        int cntA = 0;
        int cntS = 0;
        int cntD = 0;
        int cntF = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') cntA++;
            else if (c == 'S') {
                cntS++;
            } else if (c == 'D') {
                cntD++;
            } else {
                cntF++;
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                int tempA = cntA, tempS = cntS, tempD = cntD, tempF = cntF;
                int source = i;
                for (char c : s.substring(j, j + i).toCharArray()) {
                    if (c == 'A') tempA--;
                    else if (c == 'S') {
                        tempS--;
                    } else if (c == 'D') {
                        tempD--;
                    } else {
                        tempF--;
                    }
                }
                if (Math.abs(tempA - target) + Math.abs(tempS - target) + Math.abs(tempD - target) + Math.abs(tempF - target) == source) {
                    System.out.println(source);
                    return;
                }
            }
        }
    }
}
