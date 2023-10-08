import java.util.*;
import java.io.*;
public class Main {
    static int col, row;
    static char[][] map;
    static boolean[][] visited;
    static int countFor = 0;
    static int[] count = new int[3];
    static long[] answer = new long[2];
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void BFS(int recursionCol, int recursionRow, char recursionTeam){
        visited[recursionCol][recursionRow] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{recursionCol, recursionRow});
        if(recursionTeam == 'W') countFor = 0; // 내 편일 경우 배열값 0으로 저장
        else if(recursionTeam == 'B') countFor = 1; // 내 적일 경우 배열값 1로 저장
        else{ countFor = 2;}
        count[countFor]++; // 처음 들어온 map값 1로 초기화

        while (!queue.isEmpty()) {
            int oldCol = queue.peek()[0];
            int oldRow = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int newCol = oldCol + dy[i];
                int newRow = oldRow + dx[i];
                if (newCol >= 0 && newCol < col && newRow >= 0 && newRow < row){
                    if(visited[newCol][newRow]) continue;
                    if(map[newCol][newRow] != recursionTeam) continue;
                    count[countFor]++;
                    queue.offer(new int[]{newCol, newRow});
                    visited[newCol][newRow] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
        }

        map = new char[col][row];
        visited = new boolean[col][row];

        for(int i = 0; i < col; i++){
            sb.append(br.readLine()); // 입력 값이 공백이 없어서 StringTokenizer 이용 불가
            for(int j = 0; j < sb.length(); j++){
                map[i][j] = sb.charAt(j);
            }
            sb.setLength(0); // 문자열 초기화
        }

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(visited[i][j]) continue;
                count[0] = 0;
                count[1] = 0;
                countFor = -1; // 혹시 W, B값이 아닌 경우 에러날 수 있도록 -1로 초기화
                BFS(i, j, map[i][j]); // W, B값으로 분류하기 위해 변수삽입
                if(countFor == 0) answer[0] += (long)(count[0] * count[0]); // 입력값이 int값을 넘어설 수 있음
                else{ answer[1] += (long)(count[1] * count[1]); }
            }
        }

        bw.write(answer[0] + " " + answer[1] + "");
        bw.flush();
        bw.close();
    }
}