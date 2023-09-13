import java.util.*;
public class Main {
    static int n;
    static int count;
    static int[][] map;
    static boolean[][] visited;
    static int level;
    static PriorityQueue<Integer> queueFirst = new PriorityQueue<>();
    static int[] dx = new int[] {-1, 0 , 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static Scanner sc = new Scanner(System.in);
    static String str;

    public static void DFS(int x, int y){
        visited[x][y] = true;
        int nx, ny;

        for(int i = 0; i < dx.length; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    level++;
                    DFS(nx, ny);
                }
            }
        }
    }
    public static void main(String[] args) {
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        count  = 0;
        level = 1;

        for(int i = 0; i < n; i++){
            int levelUp = 0;
            str = sc.next();
            for(char temp : str.toCharArray()){
                map[i][levelUp] = temp - '0';
                levelUp++;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 && !visited[i][j]) {
                    DFS(i, j);
                    count++;
                    queueFirst.offer(level);
                    level = 1;
                }
            }
        }

        System.out.println(count);

        while(!queueFirst.isEmpty()) System.out.println(queueFirst.poll());
    }
}