import java.util.Scanner;

public class DiDi_9_17_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        if(len == 1){
            System.out.println(3);
            return;
        }
        int lastIndex = -1;
        int temp = 0;
        char[] arr = s.toCharArray();
        for(int i = 0;i < len;i++){
            char c = arr[i];
            if(c != '?'){
                temp += c - '0';
            }else{
                lastIndex = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < len;i++){
            if(arr[i] != '?'){
                sb.append(arr[i]);
            }else{
                if(i != lastIndex){
                    if(i == 0){
                        if(arr[i + 1] != '?'){
                            for(int j = 1;j < 10;j++){
                                if(j != arr[i + 1] - '0'){
                                    sb.append(j);
                                    temp += j;
                                    arr[i] = Integer.toString(j).charAt(0);
                                    break;
                                }
                            }
                        }else{
                            sb.append(1);
                            temp += 1;
                            arr[i] = Integer.toString(1).charAt(0);
                        }
                    }else if(i == len - 1){
                        for(int j = 0;j < 10;j++){
                            if(j != arr[i - 1] - '0'){
                                sb.append(j);
                                temp += j;
                                arr[i] = Integer.toString(j).charAt(0);
                                break;
                            }
                        }
                    }else{
                        if(arr[i + 1] != '?'){
                            for(int j = 0;j < 10;j++){
                                if(j != arr[i - 1] - '0' && j != arr[i + 1] - '0'){
                                    sb.append(j);
                                    temp += j;
                                    arr[i] = Integer.toString(j).charAt(0);
                                    break;
                                }
                            }
                        }else{
                            for(int j = 0;j < 10;j++){
                                if(j != arr[i - 1] - '0'){
                                    sb.append(j);
                                    temp += j;
                                    arr[i] = Integer.toString(j).charAt(0);
                                    break;
                                }
                            }
                        }
                    }
                }else{
                    if(i == 0){
                        for(int j = 1;j < 10;j++){
                            if(arr[i + 1] - '0' != j && (temp + j) % 3 == 0){
                                sb.append(j);
                                arr[i] = Integer.toString(j).charAt(0);
                                break;
                            }
                        }
                    }else if(i == len - 1){
                        for(int j = 0;j < 10;j++){
                            if(j != arr[i - 1] - '0' && (temp + j) % 3 == 0){
                                sb.append(j);
                                arr[i] = Integer.toString(j).charAt(0);
                                break;
                            }
                        }
                    }else{
                        for(int j = 0;j < 10;j++){
                            if(j != arr[i - 1] - '0' && j != arr[i + 1] - '0' && (temp + j) % 3 == 0){
                                sb.append(j);
                                arr[i] = Integer.toString(j).charAt(0);
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
