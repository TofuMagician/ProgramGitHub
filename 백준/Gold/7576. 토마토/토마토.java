import java.util.*;
import java.io.*;
public class Main {
    private static int row, col;
    private static int MAX = Integer.MIN_VALUE;
    private static int[][] map;
    private static int[] dcol = {-1, 0, 1, 0};
    private static int[] drow = {0, 1, 0, -1};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    public static void BFS(){
        Queue<Integer[]> queue = new LinkedList<>();
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(map[i][j] != 1) continue;
                queue.offer(new Integer[] {i, j, 0}); // 모두 같은 시작을 하기 위해 동일한 위치의 큐값 삽입
            }
        }
        int numberOfD = (drow.length == dcol.length) ? drow.length : -1; // 두 길이가 4인경우로 같은 경우만 4 치환

        while(!queue.isEmpty()){
            int tempCol = queue.peek()[0];
            int tempRow = queue.peek()[1];
            int tempCount = queue.peek()[2]; // Day Count를 위해 큐값 삽입
            queue.poll();
            MAX = Math.max(MAX, tempCount);

            for(int i = 0; i < numberOfD; i++){
                int newCol = tempCol + dcol[i];
                int newRow = tempRow + drow[i];
                int newCount = tempCount + 1;
                if(newCol < 0 || newCol >= col || newRow < 0 || newRow >= row) continue;
                if(map[newCol][newRow] != 0) continue;
                queue.offer(new Integer[] {newCol, newRow, newCount});
                map[newCol][newRow] = 1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        if(st.countTokens() != 0) return; // 남겨져 있는 토큰이 있는 경우 바로 종료
        map = new int[col][row];

        for(int i = 0; i < col; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < row; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            if(st.countTokens() != 0) return; // 남겨져 있는 토큰이 있는 경우 바로 종료
        }

        BFS(); // 0,0 부터 동일한 시작을 하기 위해 완전탐색 실행

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(map[i][j] == 0){
                    bw.write("-1");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }

        bw.write(MAX + "");
        bw.flush();
        bw.close();
    }
}