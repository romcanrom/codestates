package coplit.daily;

public class powerOfTwo {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(22));

    }
    static boolean powerOfTwo(long num){
        if(num<=2) return true;
        if(num%2!=0) return false;
        while(num>2){
            num = num/2;
            if(num%2!=0) return false;
        }
        return true;
    }
}
