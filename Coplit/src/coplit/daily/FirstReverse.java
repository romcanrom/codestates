package coplit.daily;

public class FirstReverse {
    public static void main(String[] args) {
        String str = "자바 구구구";
        System.out.println(firstReverse(str));
    }
    static String firstReverse(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
