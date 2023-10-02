import java.util.*;
import java.io.*;
public class Main {
    static int col, row, waste, count;
    static int answer = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dRow = new int[] {-1, 0, 1, 0};
    static int[] dCol = new int[] {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer str;
    public static void DFS(int co, int ro){
        visited[co][ro] = true;
        int Col = co;
        int Row = ro;

        for(int i = 0; i < dRow.length; i++){
            int newCol = Col + dCol[i];
            int newRow = Row + dRow[i];
            if(newCol > 0 && newCol <= col && newRow > 0 && newRow <= row){
                if(visited[newCol][newRow] || map[newCol][newRow] == 0) continue;
                count++;
                DFS(newCol, newRow);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        str = new StringTokenizer(br.readLine());
        col = Integer.parseInt(str.nextToken());
        row = Integer.parseInt(str.nextToken());
        waste = Integer.parseInt(str.nextToken());
        map = new int[col + 1][row + 1];
        visited = new boolean[col + 1][row + 1];

        for(int i = 0; i < waste; i++){
            str = new StringTokenizer(br.readLine());
            map[Integer.parseInt(str.nextToken())][Integer.parseInt(str.nextToken())] = 1;
        }

        for(int i = 1; i < col + 1; i++){
            for(int j = 1; j < row + 1; j++){
                if(map[i][j] == 0 || visited[i][j]) continue;
                count = 1;
                DFS(i,j);
                answer = Math.max(answer, count);
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}