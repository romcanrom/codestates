package coplit.daily;

public class Modulo {
    public static void main(String[] args) {
//        System.out.println(modulo(25, 4));
//        System.out.println(modulo(25, 0));

        System.out.println(moduloRe(123456789, 67));
    }

    static Integer modulo(int num1, int num2) {
        if (num1 < num2) return num1;
        if (num1 == 0) return 0;
        if (num2 == 0) return null;

        return modulo(num1 - num2, num2);
    }
    //매개값으로 큰 값을 입력받으면 stack overflow
    //재귀 호출 될 때 stack에 저장
    //메모리 측면에서 반복이 유리

    static Integer moduloRe(int num1, int num2){
        if(num1==0) return 0;
        if(num2==0) return null;

        while(num1 >= num2){
            num1 -= num2;
        }

        return num1;
    }
}
