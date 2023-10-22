import java.util.*;
import java.io.*;
public class Main {
    private static int number, left, right, sum, count;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        number = Integer.parseInt(sb.append(br.readLine()).toString());

        while(left < number){
            if(sum == number) count++;
            if(sum <= number && right < number){
                right++;
                sum += right;
                continue;
            }

            left++;
            sum -= left;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}