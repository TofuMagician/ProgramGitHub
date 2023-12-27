import java.util.*;
import java.io.*;
public class Main {
    private static int number, total, pistol;
    private static boolean[] visited;
    private static int Max = Integer.MIN_VALUE;
    private static List<Integer[]> answer = new ArrayList<>();
    private static PriorityQueue<Integer> pqueue = new PriorityQueue<>();
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static List<List<Integer>> array = new ArrayList<>();

    public static void BFS(int start){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[] {start, 0});
        visited[start] = true;

        while(!queue.isEmpty()){
            int temp = queue.peek()[0];
            int count = queue.peek()[1];
            queue.poll();
            Max = Math.max(Max, count);

            pistol = 0;
            for(int repeat : array.get(temp)){
                if(visited[repeat]) continue;
                queue.offer(new Integer[] {repeat, 1 + count});
                visited[repeat] = true;
                pistol++;
            }

            if(pistol == 0) answer.add(new Integer[] {temp, count});

        }
    }
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        number = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());
        visited = new boolean[number + 1];

        for(int i = 0; i < number + 1; i++) array.add(new ArrayList<Integer>());
        for(int i = 0; i < total; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            array.get(first).add(second);
            array.get(second).add(first);
        }

        BFS(1);

        for(int i = 0; i < answer.size(); i++){
            if(Max == answer.get(i)[1]) pqueue.offer(answer.get(i)[0]);
        }

        bw.write(pqueue.peek() + " " + Max + " " + pqueue.size());
        bw.close();
    }
}