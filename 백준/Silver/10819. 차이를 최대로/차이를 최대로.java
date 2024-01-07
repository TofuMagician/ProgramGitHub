import java.util.*;
import java.io.*;
public class Main {
    private static int total, temp;
    private static int MAX = Integer.MIN_VALUE;
    private static int[] array;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;

    public static void DFS(int start, int sum, boolean[] visited, int pistol){
        if(pistol == total - 1) MAX = Math.max(MAX, sum);
        visited[start] = true;

        for(int i = 0; i < total; i++){
            if(visited[i] == true) continue;
            temp = Math.abs(array[start] - array[i]);
            DFS(i, sum + temp, visited.clone(), pistol + 1);
        }
    }
    public static void main(String[] args) throws IOException {

        total = Integer.parseInt(br.readLine());
        array = new int[total];
        int pistol = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < total; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visit = new boolean[total];

        for(int i = 0; i < total; i++) {
            Arrays.fill(visit, false);
            DFS(i, 0, visit, 0);
        }

        bw.write(MAX + "");
        bw.close();
    }
}