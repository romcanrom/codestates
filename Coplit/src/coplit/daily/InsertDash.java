package coplit.daily;

public class InsertDash {
    public static void main(String[] args) {
        System.out.println(insertDash("454793"));

    }

    static String insertDash(String str) {
        if(str.length()==0) return null;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            int now = Integer.parseInt(str.substring(i, i + 1));
            int next = Integer.parseInt(str.substring(i + 1, i + 2));

            if (now % 2 != 0 && next % 2 != 0) sb.append(now).append('-');
            else sb.append(str.substring(i, i + 1));
        }

        sb.append(str.substring(str.length()-1));

        return String.valueOf(sb);
    }

}
