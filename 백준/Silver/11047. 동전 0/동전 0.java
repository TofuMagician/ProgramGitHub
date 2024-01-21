import java.util.*;
import java.io.*;
public class Main {
    private static int line, totalOfGoal, answer;
    private static int[] coin;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        line = Integer.parseInt(st.nextToken());
        totalOfGoal = Integer.parseInt(st.nextToken());
        coin = new int[line];

        try {
            for (int i = 0; i < line; i++) {
                coin[i] = Integer.parseInt(br.readLine());
            }
        }
        catch(Exception e){System.out.println("Failed");}

        for(int i = line - 1; i >= 0; i--){
            if(totalOfGoal <= 0) break;
            if(coin[i] > totalOfGoal) continue;
            answer += ( totalOfGoal / coin[i] );
            totalOfGoal %= coin[i];
        }

        if(totalOfGoal == 0) bw.write(answer + "");
        bw.close();
    }
}