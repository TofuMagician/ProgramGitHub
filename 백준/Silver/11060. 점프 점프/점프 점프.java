import java.util.*;
import java.io.*;
public class Main {

    static int size;
    static List<Integer> comp = new ArrayList<>();
    static List<Integer> array = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> answer = new LinkedList<>();
    static StringTokenizer str;

    public static void BFS(int start)throws IOException {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});
        comp.set(start, Math.min(comp.get(start), queue.peek()[1]));

        while(!queue.isEmpty()){

            int first = queue.peek()[0];
            int second = queue.peek()[1];

            queue.poll();

            if(first == size){
                answer.offer(second);
            }

            for(int i = 1; i < array.get(first) + 1; i++){

                if(first + i > size || comp.get(first + i) < second + i) continue;
                queue.offer(new int[] {first + i, second + 1});
                comp.set(first + i, Math.min(comp.get(first + i), second + 1));

            }
        }
    }

    public static void main(String[] args) throws IOException {

        size = Integer.parseInt(br.readLine());
        str = new StringTokenizer(br.readLine());
        array.add(0);
        comp.add(Integer.MAX_VALUE);

        while(str.hasMoreTokens()){
            array.add(Integer.parseInt(str.nextToken()));
            comp.add(Integer.MAX_VALUE);
        }
        comp.add(-1);

        BFS(1);

        if(answer.isEmpty()) bw.write("-1");
        else{ bw.write(answer.poll() + "");}
        bw.flush();
        bw.close();
    }
}