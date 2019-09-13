package test_String;

/**
 * 题目：将int[] {1,2,3}变为字符串{[word1#word2#word3]}
 *
 *
 */
public class StringPractice {
    public static void main(String[] args) {
        int[] array ={1,2,3};
        System.out.println(fromArrayToString(array));

    }

    public static String fromArrayToString(int[] array){
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            if(i == array.length -1){
                str+="word"+array[i]+"]";
            }
            else {
                str += "word" + array[i] + "#";
            }
        }
        return str;
    }
}
