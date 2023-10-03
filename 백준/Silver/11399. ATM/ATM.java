import java.util.*;
import java.io.*;
public class Main {
    static int number, sum, answer;
    static List<Integer> array = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        number = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) array.add(Integer.parseInt(st.nextToken()));

        Collections.sort(array);

        for(int temp : array){
            sum += temp;
            answer += sum;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}