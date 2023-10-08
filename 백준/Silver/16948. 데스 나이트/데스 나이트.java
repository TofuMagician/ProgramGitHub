import java.util.*;
import java.io.*;
public class Main {
    static int size, startX, startY, endX, endY, times;
    static int[][] map;
    static boolean[][] visited;
    static int[] dRow = new int[] {-2, -2, 0, 0, 2, 2};
    static int[] dCol = new int[] {-1, 1, -2, 2, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<Integer> answer = new LinkedList<>();

    public static void BFS(int chartX, int chartY){
        visited[chartY][chartX] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {chartX, chartY, times});

        while(!queue.isEmpty()){
            int oldChartX = queue.peek()[0];
            int oldChartY = queue.peek()[1];
            int oldTimes = queue.peek()[2]; // 방문 순서를 큐를 통해 poll되기 때문에 메모리용량 적게 차지함.
            queue.poll();
            int newChartTimes = oldTimes + 1;

            for(int i = 0; i < dCol.length; i++){
                int newChartX = oldChartX + dRow[i];
                int newChartY = oldChartY + dCol[i];
                if(newChartX >= 0 && newChartX < size && newChartY >=0 && newChartY < size){
                    if(visited[newChartY][newChartX]) continue; // 방문한 지역 제외하여 시간복잡도 낮춤
                    queue.offer(new int[] {newChartX, newChartY, newChartTimes});
                    visited[newChartY][newChartX] = true;
                    if(newChartX != endX || newChartY != endY) continue; // 도착시 밑 내용 실행
                    answer.offer(newChartTimes);
                    return;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());
        times = 0;

        if(startX == endX && startY == endY) answer.offer(0); // 이미 도착해 있는 경우
        else{
            BFS(startX, startY);
        }

        if(!answer.isEmpty()) bw.write(answer.poll() + ""); // 도달 했으면 answer값 1개 있음
        else{
            bw.write("-1");
        }
        bw.flush();
        bw.close();
    }
}