package coplit.daily;


public class NumberSearch {
    public static void main(String[] args) {
        int output = numberSearch("Hello6 ");
        System.out.println(output); // --> 1

        output = numberSearch("Hello6 9World 2,");
        System.out.println(output); // --> 2

        output = numberSearch("Hello6 9World 2, Nic8e D7ay!");
        System.out.println(output); // --> 2
    }
    static int numberSearch(String str){
        long len = str.chars()
                .filter(c -> c != ' ')
                .filter(c -> !Character.isDigit(c))
                .count();

        int sum = str.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sum();

        return (int) Math.round((double) sum / len);
    }
}
