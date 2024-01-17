import java.util.*;
import java.io.*;
public class Main {
    private static int col, row, item, time;
    private static int MIN = Integer.MAX_VALUE;
    private static int[][] map;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void heightMineCraft(int height){
        int total = 0;
        int temp = item;

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                int count = map[i][j] - height;
                if(count > 0){ // 블록을 캐야하는 경우
                    total += (count * 2); // mining
                    temp += count; // 인벤토리 추가
                }

                else if(count < 0){ // 블록을 추가해야 하는 경우
                    total -= count; // adding
                    temp += count; // 인벤토리 삭제
                }
            }
        }

        if(temp < 0) return; // 전체적으로 보았을 때 인벤토리 갯수가 부족해 채워넣지 못한 경우 바로 리턴 -> 불가능함

        MIN = Math.min(MIN, total);
        if(total == MIN) time = height;
    }
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        item = Integer.parseInt(st.nextToken());
        map = new int[col][row];

        for(int i = 0; i < col; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < row; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 257; i++) heightMineCraft(i);

        bw.write(MIN + " " + time + "");
        bw.close();
    }
}