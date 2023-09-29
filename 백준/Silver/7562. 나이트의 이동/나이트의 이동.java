import java.util.*;
public class Main {
    static int repeat, size;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[][] visited;
    static int[] dx = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[] {1, 2, 2, 1, -1, -2, -2, -1};
    static Queue<Integer> answer= new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void BFS(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});

        while(!queue.isEmpty()){
            int nx = queue.peek()[0];
            int ny = queue.peek()[1];
            queue.poll();
            visited[nx][ny]++;

            for(int i = 0; i < dx.length; i++){
                int nrow = nx + dx[i];
                int ncol = ny + dy[i];
                if(nrow >= 0 && nrow < size && ncol >= 0 && ncol < size){
                    if(visited[nrow][ncol] == 0){
                        queue.offer(new int[] {nrow, ncol});
                        visited[nrow][ncol] = visited[nx][ny];
                        if(nrow == end[0] && ncol == end[1]){
                            answer.offer(visited[nx][ny]);
                            return;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        repeat = sc.nextInt();
        for(int i = 0; i < repeat; i++){
            size = sc.nextInt();
            start[0] = sc.nextInt();
            start[1] = sc.nextInt();
            end[0] = sc.nextInt();
            end[1] = sc.nextInt();
            if(start[0] == end[0] && start[1] == end[1]){
                answer.offer(0);
                continue;
            }
            visited = new int[size][size];
            BFS(start[0], start[1]);
        }

        while(!answer.isEmpty()) System.out.println(answer.poll());
    }
}