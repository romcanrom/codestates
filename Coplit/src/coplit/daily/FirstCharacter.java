package coplit.daily;

public class FirstCharacter {
    public static void main(String[] args) {
        String str =  "hello world";
        System.out.println(firstCharacter(str));
    }
    static String firstCharacter(String str){
        String[] words = str.split(" ", 0);
        String result = "";
        for(String w : words){
            result += w.charAt(0);
        }
        return result;
    }
}
