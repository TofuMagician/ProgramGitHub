import java.util.*;
public class Main {

    static int node;
    static int line;
    static int start;
    static int count;
    static int[] visited;
    static Scanner sc = new Scanner(System.in);
    static List<List<Integer>> graph = new ArrayList<>();

    public static void BFS(int start){
        count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        count++;
        visited[start] = count;

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i = 0; i < graph.get(temp).size(); i++){
                int next = graph.get(temp).get(i);
                if(visited[next] == 0){
                    queue.offer(next);
                    count++;
                    visited[next] = count;
                }
            }
        }
    }
    public static void main(String[] args) {

        node = sc.nextInt();
        line = sc.nextInt();
        start = sc.nextInt();

        visited = new int[node + 1];
        Arrays.fill(visited, 0);

        for(int i = 0; i < node + 1; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < line; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i < node + 1; i++) Collections.sort(graph.get(i));

        BFS(start);

        for(int i = 1; i < visited.length; i++){
            System.out.println(visited[i]);
        }
    }
}