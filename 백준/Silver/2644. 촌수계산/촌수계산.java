import java.util.*;

public class Main {
    static int numOfPeople;
    static int first;
    static int second;
    static int line;
    static int[][] map;
    static boolean[] visited;
    static int value = 0;
    static Scanner sc = new Scanner(System.in);

    public static void DFS(int x, int count){

        visited[x] = true;
        count++;

        if(x == second) {
            value = count;
            return;
        }

        for(int i = 1; i <= numOfPeople; i++){
            if(map[x][i] == 1 && !visited[i]) DFS(i, count);
        }
    }
    public static void main(String[] args) {

        numOfPeople = sc.nextInt();
        first = sc.nextInt();
        second = sc.nextInt();
        line = sc.nextInt();
        map = new int[numOfPeople + 1][numOfPeople + 1];
        visited = new boolean[numOfPeople + 1];

        for(int i = 0; i < line; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = map[b][a] = 1;
        }

        DFS(first, 0);
        System.out.println(value - 1);
    }
}