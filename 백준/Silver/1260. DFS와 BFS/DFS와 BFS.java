import java.util.*;

public class Main{
    static int node, line, start;
    static int[] visited;
    static int count;
    static List<List<Integer>> array = new ArrayList<>();
    static Map<Integer, Integer> map = new TreeMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void BFS(int start){
        visited[start] = count;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(int i = 0; i < array.get(temp).size(); i++){
                int next = array.get(temp).get(i);
                if(visited[next] == 0){
                    queue.offer(next);
                    count++;
                    visited[next] = count;
                }
            }
        }
    }

    public static void DFS(int start){
        if(visited[start] == 0) visited[start] = count;

        for(int temp : array.get(start)){
            if(visited[temp] == 0){
                count++;
                visited[temp] = count;
                DFS(temp);
            }
        }
    }
    public static void main(String[] args){

        node = sc.nextInt();
        line = sc.nextInt();
        start = sc.nextInt();
        visited = new int[node + 1];

        for(int i = 0; i < node + 1; i++) array.add(new ArrayList<>());

        for(int i = 0; i < line; i++){
            int left = sc.nextInt();
            int right = sc.nextInt();
            array.get(left).add(right);
            array.get(right).add(left);
        }

        for(int i = 0; i < node + 1; i++) Collections.sort(array.get(i));

        count = 1;
        Arrays.fill(visited, 0);
        DFS(start);
        for(int i = 0; i < visited.length; i++) if(visited[i] != 0) map.put(visited[i], i);
        for(int temp : map.keySet()) System.out.print(map.get(temp) + " ");
        System.out.println();


        count = 1;
        Arrays.fill(visited, 0);
        BFS(start);
        for(int i = 0; i < visited.length; i++) if(visited[i] != 0) map.put(visited[i], i);
        for(int temp : map.keySet()) System.out.print(map.get(temp) + " ");

    }
}