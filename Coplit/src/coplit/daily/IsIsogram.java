package coplit.daily;

import java.util.HashMap;

public class IsIsogram {
    public static void main(String[] args) {
        boolean output = isIsogram("aba");
        System.out.println(output); // false

        output = isIsogram("Dermatoglyphics");
        System.out.println(output); // true

        output = isIsogram("moOse");
        System.out.println(output); // false

    }
    static boolean isIsogram(String str){
        if(str.length()==0) return true;
        str = str.toLowerCase();

        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)) return false;
            }
        }
        return true;
    }

    static boolean isIsogram2(String str){
        if(str.length()==0) return true;
        str = str.toLowerCase();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            if(hashMap.containsKey(str.charAt(i))) return false;
            hashMap.put(str.charAt(i), 1);
        }

        return true;
    }
}
