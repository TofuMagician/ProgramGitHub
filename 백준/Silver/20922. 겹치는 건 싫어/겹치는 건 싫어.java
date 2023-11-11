import java.util.*;
import java.io.*;
public class Main {
    private static int LengthOfSeq, LimitOfRep, start, end;
    private static int maxValue = Integer.MIN_VALUE;
    private static int[] sequence;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine()); // 수열길이 + 반복제한수 입력
        if(st.countTokens() != 2) return; // 토큰 다를 경우 반환
        LengthOfSeq = Integer.parseInt(st.nextToken());
        LimitOfRep = Integer.parseInt(st.nextToken());
        sequence = new int[LengthOfSeq + 1];
        st = new StringTokenizer(br.readLine());
        if(st.countTokens() != LengthOfSeq) return; // 토큰 다를 경우 반환
        for(int i = 0; i < LengthOfSeq; i++) sequence[i] = Integer.parseInt(st.nextToken());
        sequence[LengthOfSeq] = -1;

        for(int i = 0 ; i < sequence.length; i++){
            map.put(sequence[i], map.getOrDefault(sequence[i], 0) + 1);
            if(map.get(sequence[i]) > LimitOfRep || i == LengthOfSeq){
                maxValue = Math.max(maxValue, (i - 1) - start + 1);
                while(true){
                    map.put(sequence[start], map.getOrDefault(sequence[start], 0) - 1);
                    start++;
                    if(sequence[start - 1] == sequence[i]) break;
                }
            }
        }

        bw.write(maxValue + "");
        bw.flush();
        bw.close();
    }
}