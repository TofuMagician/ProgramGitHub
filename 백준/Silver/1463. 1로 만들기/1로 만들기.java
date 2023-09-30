import java.util.*;
public class Main {
    static int number;
    static int[] DP;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        number = sc.nextInt();
        DP = new int[number + 1];
        DP[1] = 0;

        for(int i = 2; i < number + 1; i++){
            if(i % 2 != 0 && i % 3 != 0) DP[i] = DP[i - 1] + 1;
            else {
                if (i % 2 == 0 && i % 3 == 0) {
                    DP[i] = Math.min(DP[i - 1], Math.min(DP[i / 2], DP[i / 3])) + 1;
                }

                else if (i % 2 == 0) {
                    DP[i] = Math.min(DP[i / 2], DP[i - 1]) + 1;
                }
                
                else if (i % 3 == 0) {
                    DP[i] = Math.min(DP[i / 3], DP[i - 1]) + 1;
                }
            }
        }

        System.out.println(DP[number]);
    }
}