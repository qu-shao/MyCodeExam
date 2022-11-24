import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HonorDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        HashSet<String> hs = new HashSet<>();
        sc.nextLine();
        for(int i = 0;i < len;i++){
            hs.add(sc.nextLine());
        }
        String[] data = new String[hs.size()];
        int index = 0;
        for(String el : hs){
            data[index++] = el;
        }
        Arrays.sort(data, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String o1Date = getDate(o1);
                String o2Date = getDate(o2);
                if(o1Date.compareTo(o2Date) > 0)return 1;
                else if(o1Date.compareTo(o2Date) < 0)return -1;
                else{
                    if(o1.length() > o2.length())return -1;
                    else if(o1.length() < o2.length())return 1;
                    else{
                        return o1.compareTo(o2);
                    }
                }
            }
        });
        for(String el : data){
            System.out.println(el);
        }
    }
    public static String getDate(String content){
        Pattern p = Pattern.compile("(\\d{4})-(\\d{1,2})-(\\d{1,2})[T](\\d{1,2}):(\\d{1,2}):(\\d{1,2})");
        Matcher matcher = p.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }
}
