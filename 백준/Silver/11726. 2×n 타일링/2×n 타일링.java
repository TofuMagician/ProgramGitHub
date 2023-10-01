import java.util.*;
public class Main {
    static int width;
    static int[] DP;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        width = sc.nextInt();
        DP = new int[width + 1];
        DP[1] = 1;
        if(width > 1) DP[2] = 2;
        if(width > 2) for(int i = 3; i < DP.length; i++) DP[i] = (DP[i - 1] + DP[i - 2]) % 10007 ;

        System.out.println(DP[width]);
    }
}