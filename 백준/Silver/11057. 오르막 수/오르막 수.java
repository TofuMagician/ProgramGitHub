import java.util.*;
import java.io.*;
public class Main {
    private static int length, temp, answer;
    private static Queue<Integer> queue = new LinkedList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        length = Integer.parseInt(sb.append(br.readLine()).toString());

        queue.offer(1);
        for(int i = 1; i < 10; i++){
            queue.offer(0);
        }

        for(int i = 0; i < length; i++){
            temp = 0;
            for(int j = 0; j < 10; j++){
                temp += queue.poll();
                queue.offer(temp % 10007);
            }
        }

        while(!queue.isEmpty()) answer += queue.poll();

        bw.write((answer % 10007) + "");
        bw.flush();
        bw.close();
    }
}