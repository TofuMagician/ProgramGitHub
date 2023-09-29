import java.util.*;
public class Main {
    static int node, line, count;
    static Scanner sc = new Scanner(System.in);
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int content = queue.poll();
            for(int temp : graph.get(content)){
                if(!visited[temp]){
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
    }
    public static void main(String[] args){

        node = sc.nextInt();
        line = sc.nextInt();
        visited = new boolean[node + 1];

        for(int i = 0; i < node + 1; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < line; i++){
            int tempFirst = sc.nextInt();
            int tempSecond = sc.nextInt();
            graph.get(tempFirst).add(tempSecond);
            graph.get(tempSecond).add(tempFirst);
        }

        for(int i = 1; i < node + 1; i++){
            if(!visited[i]){
                BFS(i);
                count++;
            }
        }

        System.out.println(count);
    }
}