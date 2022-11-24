import java.util.HashMap;
import java.util.Scanner;

public class Monkey_8_26_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();
        for(int i = 0;i < m;i++){
            int res = 0;
            String[] searchWords = in.nextLine().toLowerCase().split(" ");
            String[] stopWords = in.nextLine().toLowerCase().split(" ");
            HashMap<String ,Integer> help = new HashMap<>();
            for(int j = 1;j < searchWords.length;j++){
                if(help.containsKey(searchWords[j])){
                    help.replace(searchWords[j], help.get(searchWords[j]) + 1);
                }else{
                    help.put(searchWords[j], 1);
                }
            }
            String[] matchWords = new String[stopWords.length - 1];
            for(int j = 1;j < stopWords.length;j++){
                matchWords[j - 1] = stopWords[j].replaceAll("\\?", ".");
            }
            for(String el : help.keySet()){
                boolean isValid = true;
                for(String mat : matchWords){
                    if(el.length() != mat.length())continue;
                    if(el.matches(mat)){
                        isValid = false;
                        break;
                    }
                }
                if(isValid){
                    res = Math.max(res, help.get(el));
                }
            }
            System.out.println(res);
        }
    }
}
