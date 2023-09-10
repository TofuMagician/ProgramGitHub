import java.util.*;

public class Main {
    static Set<String> setFirst = new HashSet<>();
    static String text_F = new String();
    static int n = 5;
    static int[][] map = new int[5][5];
    static Scanner sc = new Scanner(System.in);
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static void DFS(int x, int y, String text) throws Exception{

        int nx = x;
        int ny = y;

        text += map[nx][ny] + "";

        if(text.length() == 6){
            setFirst.add(text);
            return;
        }

        for(int i = 0; i < dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                DFS(nx, ny, text);
            }
        }
    }
    public static void main(String[] args) throws Exception{

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                DFS(i, j, text_F);
            }
        }

        System.out.print(setFirst.size());
    }
}