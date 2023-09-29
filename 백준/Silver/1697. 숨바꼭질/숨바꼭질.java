import java.util.*;
public class Main {
    static int start, end;
    static int[] visited = new int[100001];
    static Scanner sc = new Scanner(System.in);
    public static int Plus(int input){
        return input + 1;
    }

    public static int Minus(int input){
        return input - 1;
    }

    public static int Multiply(int input){
        return 2 * input;
    }

    public static void BFS(int start){
        if(start == end) {
            System.out.println(0);
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(Plus(temp) >= 0 && Plus(temp) <= 100000 && visited[Plus(temp)] == 0){
                queue.offer(Plus(temp));
                visited[Plus(temp)] = visited[temp];
                visited[Plus(temp)]++;
                if(Plus(temp) == end){
                    System.out.println(visited[Plus(temp)]);
                    return;
                }
            }
            if(Minus(temp) >= 0 && Minus(temp) <= 100000 && visited[Minus(temp)] == 0){
                queue.offer(Minus(temp));
                visited[Minus(temp)] = visited[temp];
                visited[Minus(temp)]++;
                if(Minus(temp) == end){
                    System.out.println(visited[Minus(temp)]);
                    return;
                }
            }
            if(Multiply(temp) >= 0 && Multiply(temp) <= 100000 && visited[Multiply(temp)] == 0){
                queue.offer(Multiply(temp));
                visited[Multiply(temp)] = visited[temp];
                visited[Multiply(temp)]++;
                if(Multiply(temp) == end){
                    System.out.println(visited[Multiply(temp)]);
                    return;
                }
            }
        }
    }
    public static void main(String[] args){

        start = sc.nextInt();
        end = sc.nextInt();
        Arrays.fill(visited, 0);
        BFS(start);
    }
}