import java.util.*;
import java.io.*;
public class Main {
    static int col, row, nCol, nRow;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer str;
    static int[][] map;
    static int[][] visited;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    public static void BFS(int co, int ro){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[] {co, ro});
        visited[co][ro] = 1;

        while(!queue.isEmpty()){
            int oCo = queue.peek()[0];
            int oRo = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < dx.length; i++){
                int nCo = oCo + dy[i];
                int nRo = oRo + dx[i];
                if(nCo >= 0 && nCo < col && nRo >= 0 && nRo < row){
                    if(visited[nCo][nRo] != -1) continue;
                    if(map[nCo][nRo] != 1) continue;
                    queue.offer(new Integer[] {nCo, nRo});
                    visited[nCo][nRo] = visited[oCo][oRo] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        str = new StringTokenizer(br.readLine());
        col = Integer.parseInt(str.nextToken());
        row = Integer.parseInt(str.nextToken());

        map = new int[col][row];
        visited = new int[col][row];

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                visited[i][j] = -1;
            }
        }

        for(int i = 0; i < col; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < row; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
                if(map[i][j] == 0) visited[i][j] = 0;
                if(map[i][j] == 2){
                    nCol = i;
                    nRow = j;
                    map[i][j] = 1;
                }
            }
        }


        BFS(nCol, nRow);

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(visited[i][j] > 0){
                    bw.write((visited[i][j] - 1) + " ");
                }
                else{ bw.write(visited[i][j] + " "); }
            }
            bw.newLine();
        }
        bw.close();
    }
}