import java.util.*;
import java.io.*;
public class Main {
    static int repeat, times;
    static Queue<Long> answer = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Long[] DP;
    public static void main(String[] args) throws IOException {

        repeat = Integer.parseInt(br.readLine());

        for(int i = 0; i < repeat; i++){
            times = Integer.parseInt(br.readLine());
            DP = new Long[times + 2];

            if(times + 1 <= 4){
                answer.offer((long)1);
                continue;
            }
            DP[0] = (long)1;
            DP[1] = (long)1;
            DP[2] = (long)1;
            DP[3] = (long)1;
            DP[4] = (long)1;
            if(times + 1 <= 6){
                answer.offer((long)2);
                continue;
            }
            DP[5] = (long)2;
            DP[6] = (long)2;

            for(int j = 7; j <= times + 1; j++){
                DP[j] = DP[j-1] + DP[j-5];
            }

            answer.offer(DP[times + 1]);
        }

        while(!answer.isEmpty()){
            bw.write(answer.poll() + "");
            bw.flush();
            bw.newLine();
        }

        bw.close();
    }
}