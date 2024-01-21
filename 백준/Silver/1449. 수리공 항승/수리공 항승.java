import java.util.*;
import java.io.*;
public class Main {
    private static int total, length, answer;
    private static int[] pipe;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        total = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        pipe = new int[total];
        st = new StringTokenizer(br.readLine());
        try {
            for (int i = 0; i < total; i++) pipe[i] = Integer.parseInt(st.nextToken());
        }
        catch(Exception e){ System.out.println("Failed"); }

        Arrays.sort(pipe);

        for(int i = 0; i < pipe.length; i++){
            if(pipe[i] < 0) continue;
            answer++;
            for(int j = i + 1; j < pipe.length; j++){
                if(pipe[i] + length - 1 >= pipe[j]) pipe[j] = -1;
                else{ break; }
            }
        }

        bw.write(answer + "");
        bw.close();
    }
}