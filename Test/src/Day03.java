public class Day03 {
    //1.找出最长的数字子字符串
    public static String subString(String s){
        StringBuffer result = new StringBuffer();
        char[] chars = s.toCharArray();
        int i = 0;
        while(i < chars.length){
            StringBuffer sb = new StringBuffer();
            while(i < chars.length && chars[i] < '0' || chars[i] >'9'){
                i++;
            }
            while(i < chars.length && chars[i] >= '0' && chars[i] <= '9'){
                sb.append(chars[i]);
                i++;
            }
            if(sb.length() > result.length()){
                result = sb;
            }
        }

        return result.toString();
    }


    //第二题


    public static void main(String[] args) {
        String s = "abcd1234567unsdf7888232342355";
        String s1 = subString(s);
        System.out.println(s1);

    }
}
