import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stn;
    static int node, line, number, start;
    static List<List<Integer>> array = new ArrayList<>();
    static PriorityQueue<Integer> pQueue = new PriorityQueue<>();
    static boolean[] visited;
    public static void BFS(int start){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[] {start, 0});
        visited[start] = true;

        while(!queue.isEmpty()){
            int tempFirst = queue.peek()[0];
            int tempSecond = queue.peek()[1];
            queue.poll();

            if(tempSecond == number) pQueue.offer(tempFirst);

            for(int temp : array.get(tempFirst)){
                if(visited[temp] || tempSecond + 1 > number) continue;
                queue.offer(new Integer[] {temp, tempSecond + 1});
                visited[temp] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        stn = new StringTokenizer(br.readLine());
        node = Integer.parseInt(stn.nextToken());
        line = Integer.parseInt(stn.nextToken());
        number = Integer.parseInt(stn.nextToken());
        start = Integer.parseInt(stn.nextToken());
        visited = new boolean[node + 1];

        for(int i = 0; i < node + 1; i++) array.add(new ArrayList<>());

        for(int i = 0; i < line; i++){
            stn = new StringTokenizer(br.readLine());
            array.get(Integer.parseInt(stn.nextToken())).add(Integer.parseInt(stn.nextToken()));
        }

        BFS(start);

        if(pQueue.isEmpty()) bw.write("-1");
        else {
            while (!pQueue.isEmpty()){
                bw.write(pQueue.poll() + "");
                bw.newLine();
                bw.flush();
            }
        }
        bw.close();
    }
}