package coplit.daily;

public class LetterCapitalize {
    public static void main(String[] args) {
        String str = "nEVER  gIVE uP";

        //System.out.println(letterCapitalize(str));

        String[] words = str.split(" ");
        for(String word : words) {
            System.out.println(word);
            System.out.println(word.length()==0);
        }


    }
    static String letterCapitalize(String str) {
        if(str.length()==0) return "";

        String[] words = str.split(" ");
        String result = "";

        for(int i=0; i<words.length; i++){
            if(words[i].length()==0) result+= " ";
            else{
                words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
                result += words[i] + " ";
            }
        }

        return result.trim();
    }
}
