package coplit.daily;

public class Power {
    public static void main(String[] args) {
        long output = power(3, 40);
        System.out.println(output); // --> 19334827
    }
    public static long power(int base, int exponent) {
        if(exponent == 0) return 1;

        long half = power(base, exponent/2);
        long result = (half * half) % 94906249;

        if(exponent % 2 == 0) return result;
        else return (result * base) % 94906249;
    }
}
