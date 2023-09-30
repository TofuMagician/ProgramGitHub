import java.util.*;
public class Main {
    static int[] DP;
    static int repeat;
    static Scanner sc = new Scanner(System.in);
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args){
        repeat = sc.nextInt();

        for(int i = 0; i < repeat; i++){
            int number = sc.nextInt();
            DP = new int[number + 1];

            if(number < 4){
                if(number == 1) queue.offer(1);
                if(number == 2) queue.offer(2);
                if(number == 3) queue.offer(4);
                continue;
            }
            DP[1] = 1;
            DP[2] = 2;
            DP[3] = 4;

            for(int j = 4; j < number + 1; j++) DP[j] = DP[j-1] + DP[j-2] + DP[j-3];

            queue.offer(DP[number]);
        }

        while(!queue.isEmpty()) System.out.println(queue.poll());
    }
}