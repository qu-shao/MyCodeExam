// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;
public class XingHuan_10_15_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        Deque<Integer> help = new LinkedList<>();
        help.add(n);
        for(int i = n - 1;i >= 0;i--){
            if(s.charAt(i) == 'L'){
                help.addLast(i);
            }else{
                help.addFirst(i);
            }
        }
        for(int el : help){
            System.out.print(el + " ");
        }
    }
}