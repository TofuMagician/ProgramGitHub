import java.util.*;
import java.io.*;
public class Main {
    private static int west, east;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int[] DP;

    public static int DFS(int recur){
        if(DP[recur] != -1) return DP[recur];

        DP[recur] = (DFS(recur - 2) + DFS(recur - 1)) % 15746;
        return DP[recur];
    }
    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());
        if(size < 2){
            bw.write("1");
            bw.close();
            return;
        }
        if(size < 3){
            bw.write("2");
            bw.close();
            return;
        }
        DP = new int[size + 1];
        Arrays.fill(DP, -1);
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;

        bw.write(DFS(size)+ "");
        bw.flush();
        bw.close();
    }
}