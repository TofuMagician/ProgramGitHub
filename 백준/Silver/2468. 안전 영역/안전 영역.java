import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static TreeSet<Integer> setFirst = new TreeSet<>();
    static int count; // 영역 카운트
    static int MAX = Integer.MIN_VALUE; // 최댓값 반환
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0 , -1};
    static boolean[][] flooded; // 홍수로 침범된 배열
    static boolean[][] visited; // 방문한 배열
    static Scanner sc = new Scanner(System.in);

    public static void DFS(int x, int y){

        visited[x][y] = true;

        int nx;
        int ny;

        for(int i = 0; i < dx.length; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                if(!visited[nx][ny] && !flooded[nx][ny]) DFS(nx, ny);
            }
        }
    }
    public static void main(String[] args) {

        n = sc.nextInt();
        map = new int[n][n];
        flooded = new boolean[n][n];
        visited = new boolean[n][n];

        setFirst.add(-1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
                setFirst.add(map[i][j]);
            }
        }

        for(int temp : setFirst){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] == temp) flooded[i][j] = true; // 홍수로 침범 된 지역먼저 초기화
                }
            }

            count = 0; // 카운트 0으로 초기화

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!flooded[i][j] && !visited[i][j]) {
                        DFS(i, j);
                        count++;
                    }
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    visited[i][j] = false; // 방문기록 초기화
                }
            }

            MAX = Math.max(MAX, count);
        }

        System.out.println(MAX);

    }
}