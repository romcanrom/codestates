package coplit.daily;

public class computeWhenDouble {
    public static void main(String[] args) {

    }
    static int computeWhenDouble(double interestRate){
        interestRate = 1 + interestRate/100;
        double money = 1;
        int year = 0;
        while(money<2) {
            money = money*interestRate;
            year++;
        }
        return year;
    }
}
