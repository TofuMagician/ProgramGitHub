import java.util.*;
public class Main {
    static int building, start, end, up, down;
    static Queue<Integer> answer = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    static boolean[] visited;

    public static void BFS(int stair){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[] {stair, 0});
        visited[stair] = true;

        while(!queue.isEmpty()){
            int tempFirst = queue.peek()[0];
            int tempSecond = queue.peek()[1];
            queue.poll();
            if(tempFirst == end){
                answer.offer(tempSecond);
                return;
            }
            if(tempFirst + up > 0 && tempFirst + up < building + 1){
                if(!visited[tempFirst + up]){
                    queue.offer(new Integer[] {tempFirst + up, tempSecond + 1});
                    visited[tempFirst + up] = true;
                }
            }
            if(tempFirst - down > 0 && tempFirst - down < building + 1){
                if(!visited[tempFirst - down]) {
                    queue.offer(new Integer[]{tempFirst - down, tempSecond + 1});
                    visited[tempFirst - down] = true;
                }
            }
        }
    }
    public static void main(String[] args){
        building = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        up = sc.nextInt();
        down = sc.nextInt();
        visited = new boolean[building + 1];
        BFS(start);
        System.out.println(!answer.isEmpty() ? answer.poll() : "use the stairs");
    }
}