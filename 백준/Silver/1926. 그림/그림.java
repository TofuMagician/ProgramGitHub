import java.util.Scanner;

public class Main {

    static int col;
    static int row;
    static int count = 0;
    static int size;
    static int maxSize = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0,1, 0, -1};
    static Scanner sc = new Scanner(System.in);

    public static void DFS(int y, int x){
        visited[y][x] = true;
        int ny;
        int nx;
        size++;

        for(int i = 0; i < dx.length; i++){
            ny = y + dx[i];
            nx = x + dy[i];
            if(nx >= 0 && nx < row && ny >= 0 && ny < col){
                if(map[ny][nx] != 0 && !visited[ny][nx]){
                    DFS(ny, nx);
                }
            }
        }
    }
    public static void main(String[] args) {

        col = sc.nextInt();
        row = sc.nextInt();
        map = new int[col][row];
        visited = new boolean[col][row];

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    size = 0;
                    DFS(i, j);
                    maxSize = Math.max(maxSize, size);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);

    }
}