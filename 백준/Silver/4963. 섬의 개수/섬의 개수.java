import java.util.*;

public class Main {

    static int H, W;
    static int[] dx = new int[] {-1, 0, 1, 0, -1, 1, -1, 1};
    static int[] dy = new int[] {0, 1, 0, -1, 1, -1, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int count;

    public static void DFS(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < H && ny < W){
                if(map[nx][ny] == 1 && !visited[nx][ny]) DFS(nx, ny);
            }
        }


    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        while(true){

            W = sc.nextInt();
            H = sc.nextInt();

            if(H == 0 && W == 0) System.exit(0);

            map = new int[H][W];
            visited = new boolean[H][W];


            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            count = 0;

            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        DFS(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}