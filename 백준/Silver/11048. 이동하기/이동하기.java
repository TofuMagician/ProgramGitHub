import java.util.*;
import java.io.*;
public class Main {
    private static int col, row;
    private static int[][] map;
    private static int[][] DP;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void maxValue(int i, int j){
        int Max = Integer.MIN_VALUE;
        if(i >= col + 1 || j >= row + 1) return; // 범위를 벗어난 경우 리턴해서 없애기
        if(i - 1 > 0 && j - 1 > 0) Max = Math.max(Max, DP[i - 1][j - 1] + map[i][j]);
        if(i - 1 > 0 && j > 0) Max = Math.max(Max, DP[i - 1][j] + map[i][j]);
        if(i > 0 &&  j - 1 > 0) Max = Math.max(Max, DP[i][j - 1] + map[i][j]);
        DP[i][j] = Max;
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[col + 1][row + 1];
        DP = new int[col + 1][row + 1];

        for(int i = 1; i < col + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < row + 1; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        DP[1][1] = map[1][1];

        for(int i = 1; i < col + 1; i++){
            for(int j = 1; j < row + 1; j++){
                if(i == 1 && j == 1) continue;
                if(i != j){ // 순서를 낮은 수준에서 시작하기 위해 i,j로 구별
                    maxValue(i, j);
                    maxValue(j, i);
                }
                else{
                    maxValue(i, j);
                }
            }
        }

        bw.write(DP[col][row] + "");
        bw.close();

    }

}