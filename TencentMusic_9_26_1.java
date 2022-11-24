public class TencentMusic_9_26_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串 
     * @return int整型
     */
    public int minOperations (String str) {
        // write code here
        int toZero = 0;
        int toOne = 0;
        int len = str.length();
        int index = 0;
        while(index < len){
            if(str.charAt(index) == '1')index++;
            else{
                toOne++;
                index += 2;
            }
        }
        index = 0;
        while(index < len){
            if(str.charAt(index) == '0')index++;
            else{
                toZero++;
                index += 2;
            }
        }
        return Math.min(toOne, toZero);
    }
}