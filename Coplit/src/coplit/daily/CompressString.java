package coplit.daily;

public class CompressString {
    public static void main(String[] args) {
        String output = compressString("abc");
        System.out.println(output); // --> "abc"

        output = compressString("wwwggoppopppp");
        System.out.println(output); // --> "3wggoppo4p"
    }

    static String compressString(String str) {
        if(str.length()==0) return str;

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i-1) == str.charAt(i)) count++;
            else if(count < 3) {
                String sub = str.substring(i-count, i);
                sb.append(sub);
                count = 1;
            }
            else { //count >= 3
                sb.append(count).append(str.charAt(i-1));
                count = 1;
            }
        }
        if(count==1) sb.append(str.charAt(str.length()-1));
        else if(count==2) sb.append(str.charAt(str.length()-2)).append(str.charAt(str.length()-1));
        else sb.append(count).append(str.charAt(str.length()-1));

        return String.valueOf(sb);
    }
}
