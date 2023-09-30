import java.util.*;
public class Main {
    static long length, sum;
    static String number;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        sum = 0;
        length = sc.nextLong();
        number = sc.next();
        StringBuilder str = new StringBuilder();
        str.append(number);

        for(int i = 0; i < length; i++){
            sum += str.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}