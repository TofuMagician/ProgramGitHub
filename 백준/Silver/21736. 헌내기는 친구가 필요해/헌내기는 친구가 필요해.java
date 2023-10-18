import java.util.*;
import java.io.*;
public class Main {
    private static int col, row, colI, rowI, count;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] drow = new int[] {-1, 0, 1, 0};
    private static int[] dcol = new int[] {0, 1, 0, -1};

    public static void BFS(int colI, int rowI){
        visited[colI][rowI] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {colI, rowI});

        while(!queue.isEmpty()){
            int startCol = queue.peek()[0];
            int startRow = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < dcol.length; i++){
                int newCol = startCol + dcol[i];
                int newRow = startRow + drow[i];

                if(newCol < 0 || newCol >= col || newRow < 0 || newRow >= row) continue;
                if(visited[newCol][newRow]) continue;
                if(map[newCol][newRow] != 'O' && map[newCol][newRow] != 'P') continue;

                if(map[newCol][newRow] == 'P') count++;
                queue.offer(new int[] {newCol, newRow});
                visited[newCol][newRow] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new char[col][row];
        visited = new boolean[col][row];

        for(int i = 0; i < col; i++){
            sb.append(br.readLine());
            for(int j = 0; j < row; j++){
                map[i][j] = sb.charAt(j);
                if(map[i][j] != 'I') continue;
                colI = i;
                rowI = j;
            }
            sb.setLength(0);
        }

        BFS(colI, rowI);

        String answer = (count == 0) ? "TT" : count + "";
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}