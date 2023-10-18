import java.util.*;
import java.io.*;
public class Main {
    private static int size, left, right, sum, count;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static List<Integer> array = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int capacity = st.countTokens();
        if(capacity != size) return;
        for(int i = 0; i < size; i++){
            array.add(Integer.parseInt(st.nextToken()));
        }
        sum = Integer.parseInt(br.readLine());

        Collections.sort(array);

        left = 0;
        right = size - 1;

        while(left < right){
            int temp = array.get(left) + array.get(right);
            if(temp == sum){
                count++;
                left++;
            }
            if(temp > sum) right--;
            if(temp < sum) left++;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}