package coplit.daily;

public class ABCheck {
    public static void main(String[] args) {

        String str = "HK9J6YjrAcMbq8qKrbS3EaPRT";
        String str2 = "aMAJ7sBrO4CyysuoHFrgGTX";

        System.out.println(ABCheck(str));


    }

    static boolean ABCheck(String str) {
        str = str.toLowerCase();
        for(int i=0; i<str.length()-5; i++){
            String check = str.substring(i, i+5);
            if(check.charAt(0)=='a' && check.charAt(check.length()-1)=='b') return true;
            if(check.charAt(0)=='b' && check.charAt(check.length()-1)=='a') return true;
        }

        return false;
    }
}
