import java.util.*;
import java.io.*;
public class Main {
    private static int total;
    private static int[] variable;
    private static int[] DP;
    private static int Max = Integer.MIN_VALUE;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        if(st.countTokens() != 1) return;
        total = Integer.parseInt(st.nextToken()) + 1;
        variable = new int[total];
        variable[0] = 0;
        DP = new int[total];
        st = new StringTokenizer(br.readLine());
        if(st.countTokens() != total - 1) return;

        for(int i = 1; i < total; i++) variable[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < total; i++){
            DP[i] = variable[i];
            for(int j = i - 1; j > 0; j--){
                if(variable[i] <= variable[j]) continue;
                DP[i] = Math.max(DP[i], variable[i] + DP[j]);
            }
            Max = Math.max(Max,DP[i]);
        }

        bw.write(Max + "");
        bw.close();
    }
}
