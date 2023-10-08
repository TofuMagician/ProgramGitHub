import java.util.*;
import java.io.*;
public class Main {
    static int line, maxValue, count;
    static int[][] array;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        line = Integer.parseInt(br.readLine());
        array = new int[line][2];

        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                array[i][0] = (Integer.parseInt(st.nextToken()));
                array[i][1] = (Integer.parseInt(st.nextToken()));
            }
        }

        Arrays.sort(array, (o1, o2) -> {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
        });

        for(int i = 0; i < line; i++){
            if(maxValue <= array[i][0]){
                maxValue = array[i][1];
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}