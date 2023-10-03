import java.util.*;
import java.io.*;
public class Main {
    static int house;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int MIN;
    static StringTokenizer st;
    static List<int[]> array = new ArrayList<>();
    static List<int[]> visited = new ArrayList<>();
    static PriorityQueue<Integer> pqueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        house = Integer.parseInt(br.readLine());

        for(int i = 0; i < house; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                int third = Integer.parseInt(st.nextToken());
                array.add(new int[] {first, second, third});
                visited.add(new int[] {0 ,0, 0});
            }
        }


        visited.get(0)[0] = array.get(0)[0];
        visited.get(0)[1] = array.get(0)[1];
        visited.get(0)[2] = array.get(0)[2];

        for(int i = 1; i < array.size(); i++){
            for(int j = 0; j < 3; j++){
                MIN = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++){
                    if(j == k) continue;
                    MIN = Math.min(MIN, visited.get(i - 1)[k]);
                }
                visited.get(i)[j] = MIN + array.get(i)[j];
            }
        }

        for(int i = 0; i < 3; i++){
            pqueue.offer(visited.get(array.size() - 1)[i]);
        }

        bw.write(pqueue.poll() + "");
        bw.flush();
        bw.close();
    }
}