package coplit.algorithm;

public class Barcode {
    public static void main(String[] args) {

    }

    public String barcode(int len){
        return aux("", len);
    }

    public boolean isValid(String str){
        StringBuilder sb = new StringBuilder(str);
        String reverse = sb.reverse().toString();

        int halfLen = (int) Math.floor((double)str.length()/2);

        for(int i=1; i<=halfLen; i++){
            if(reverse.substring(0, i).equals(reverse.substring(i, i+i))){
                return false;
            }
        }
        return true;
    }

    public String aux(String str, int len){
        String chr = "123";

        if(str.length()==len) return str;

        for(int i=0; i<chr.length(); i++){
            String currentStr = str + chr.charAt(i);
            if(isValid(currentStr)){
                String founded = aux(currentStr, len);
                if(founded != null) return founded;
            }
        }
        return null;
    }
}
