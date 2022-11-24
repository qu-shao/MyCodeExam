import java.util.HashSet;

public class XinYe_9_22_1 {
    public int dateArraysSum (String[] dates) {
        // write code here
        HashSet<String> hs = new HashSet<>();
        int sum = 0;
        int arr[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(String s : dates){
            if(!hs.contains(s)){
                hs.add(s);
                String[] help = s.split("\\s+");
                if(help.length != 3)continue;
                int year = Integer.parseInt(help[2]);
                int month = getMonth(help[1]);
                if(month == 0)continue;
                int day = getDay(help[0]);
                for(int i = 0;i < month - 1;i++){
                    sum += arr[i];
                }
                sum += day;
                if(isRun(year) && month >= 3)sum++;
            }
        }
        return sum;
    }
    public int getDay(String day){
        int temp = 0;
        for(int i = 0;i < day.length();i++){
            if(day.charAt(i) >= '0' && day.charAt(i) <= '9'){
                temp = temp * 10 + (day.charAt(i) - '0');
            }else{
                break;
            }
        }
        return temp;
    }
    public int getMonth(String s){
        if(s.equals("Jan"))return 1;
        else if(s.equals("Feb"))return 2;
        else if(s.equals("Mar"))return 3;
        else if(s.equals("Apr"))return 4;
        else if(s.equals("May"))return 5;
        else if(s.equals("Jun"))return 6;
        else if(s.equals("Jul"))return 7;
        else if(s.equals("Aug"))return 8;
        else if(s.equals("Sep"))return 9;
        else if(s.equals("Oct"))return 10;
        else if(s.equals("Nov"))return 11;
        else if(s.equals("Dec"))return 12;
        else return 0;
    }
    public boolean isRun(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)return true;
        return false;
    }
}
