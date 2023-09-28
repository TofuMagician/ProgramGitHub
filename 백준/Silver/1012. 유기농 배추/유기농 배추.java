import java.util.*;

public class Main{
    static int row, col, number, repeatTimes;
    static int count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = new int[] {0, 1, 0, -1};
    static int[] dx = new int[] {-1, 0, 1, 0};
    static Queue<Integer> answer = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    public static void BFS(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()){
            int tempY = queue.peek()[0];
            int tempX = queue.peek()[1];
            queue.poll();
            for(int i = 0; i < dx.length; i++){
                int ny = tempY + dy[i];
                int nx = tempX + dx[i];

                if(ny >= 0 && ny < col && nx >= 0 && nx < row){
                    if(map[ny][nx] == 1 && !visited[ny][nx]){
                        queue.add(new int[] {ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        repeatTimes = sc.nextInt();

        for(int i = 0; i < repeatTimes; i++){
            count = 0;
            row = sc.nextInt();
            col = sc.nextInt();
            number = sc.nextInt();
            map = new int[col][row];
            visited = new boolean[col][row];

            for(int j = 0; j < col; j++){
                for(int k = 0; k < row; k++){
                    map[j][k] = 0;
                    visited[j][k] = false;
                }
            }

            for(int j = 0; j < number; j++){
                int ro = sc.nextInt();
                int co = sc.nextInt();
                map[co][ro] = 1;
            }

            for(int j = 0; j < col; j++){
                for(int k = 0; k < row; k++){
                    if(map[j][k] == 1 && !visited[j][k]){
                        BFS(j, k);
                        count++;
                    }
                }
            }

            answer.offer(count);
        }

        while(!answer.isEmpty()) System.out.println(answer.poll());
    }
}