import java.util.*;
public class Main {
    static int node, line;
    static Scanner sc = new Scanner(System.in);
    static List<List<Integer>> graph = new ArrayList<>();
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args){

        node = sc.nextInt();
        line = node - 1;
        visited = new boolean[node + 1];

        for(int i = 0; i < node + 1; i++){
            graph.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        for(int i = 0; i < line; i++){
            int tempF = sc.nextInt();
            int tempS = sc.nextInt();
            graph.get(tempF).add(tempS);
            graph.get(tempS).add(tempF);
        }

        while(!queue.isEmpty()){
            int content = queue.poll();
            for(int temp : graph.get(content)){
                if(!visited[temp]) {
                    tree.get(temp).add(content);
                    queue.offer(temp);
                    visited[content] = true;
                }
            }
        }

        for(int i = 2; i < node + 1; i++) System.out.println(tree.get(i).get(0));
    }
}