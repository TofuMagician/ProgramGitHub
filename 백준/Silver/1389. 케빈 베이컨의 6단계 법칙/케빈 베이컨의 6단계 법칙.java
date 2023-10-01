import java.util.*;
public class Main {
    static int node, line;
    static int min = Integer.MAX_VALUE;
    static Map<Integer, Integer> map = new HashMap<>();
    static int[] visited;
    static List<List<Integer>> array = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static int Sum(int[] visited){
        int sum = 0;
        for(int i = 1; i < visited.length; i++) sum += visited[i];
        return sum;
    }
    public static void BFS(int start){
        visited = new int[node + 1];
        Arrays.fill(visited, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int show = queue.poll();

            for(int temp : array.get(show)){
                if(visited[temp] == 0){
                    queue.offer(temp);
                    visited[temp] = visited[show] + 1;
                }
            }
        }
    }
    public static void main(String[] args){

        node = sc.nextInt();
        line = sc.nextInt();

        for(int i = 0; i < node + 1; i++) array.add(new ArrayList<>());

        for(int i = 0; i < line; i++){
            int nodeFirst = sc.nextInt();
            int nodeSecond = sc.nextInt();
            array.get(nodeFirst).add(nodeSecond);
            array.get(nodeSecond).add(nodeFirst);
        }

        for(int i = 1; i < node + 1; i++){
            BFS(i);
            map.put(i, Sum(visited));
        }

        for(int temp : map.keySet()) min = Math.min(min, map.get(temp));

        for(int temp : map.keySet()){

            if(map.get(temp) == min) answer.add(temp);
        }

        Collections.sort(answer);

        System.out.println(answer.get(0));
    }
}