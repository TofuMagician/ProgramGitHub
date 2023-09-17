import java.util.*;

public class Main {
    static int node;
    static int line;
    static int[][] map;
    static boolean[] visited;
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void DFS(int x){
        visited[x] = true;
        count++;

        for(int i = 1; i <= node; i++){
            if(map[x][i] == 1 && !visited[i]) DFS(i);
        }

    }
    public static void main(String[] args) {

        node = sc.nextInt();
        line = sc.nextInt();

        map = new int[node + 1][node + 1];
        visited = new boolean[node + 1];


        for(int i = 0; i < line; i++){
            int first = sc.nextInt();
            int second = sc.nextInt();

            map[first][second] = map[second][first] = 1;
        }

        DFS(1);

        System.out.println(count - 1);
    }
}