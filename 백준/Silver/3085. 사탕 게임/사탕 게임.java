import java.util.*;
import java.io.*;

public class Main {
    private static int len, answer;
    private static int MAX = Integer.MIN_VALUE;
    private static char[][] map;
    private static Stack<Character> stack = new Stack<>();
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void CrossH(){
        for(int i = 0; i < len; i++){
            stack.push('0'); // 0(색깔이 아닌 처음값)
            answer = 0;
            for(int j = 0; j < len; j++){
                if(stack.peek() != map[i][j]){
                    stack.push(map[i][j]); // 연결이 끊길 경우 값 추가
                    answer = 0; // 연결이 끊기면 바로 0으로 초기화
                }
                else{ // 연결성이 유지될 때 색깔과 관련없이 answer값 추가
                    answer++;
                    MAX = Math.max(MAX, answer); // 어쨋든 최댓값만 얻으면 됨.
                }
            }
            stack.clear();
        }
    }

    public static void CrossV(){
        for(int i = 0; i < len; i++){
            stack.push('0'); // 0(색깔이 아닌 처음값)
            answer = 0;
            for(int j = 0; j < len; j++){
                if(stack.peek() != map[j][i]){
                    stack.push(map[j][i]); // 연결이 끊길 경우 값 추가
                    answer = 0; // 연결이 끊기면 바로 0으로 초기화
                }
                else{ // 연결성이 유지될 때 색깔과 관련없이 answer값 추가
                    answer++;
                    MAX = Math.max(MAX, answer); // 어쨋든 최댓값만 얻으면 됨.
                }
            }
            stack.clear();
        }
    }
    public static void SwapV(int col, int row){
        // swap하고 다시 돌려놓기 -> 시간복잡도 성능향상
        if(col == len - 1) return;
        // 수직 swap
        swapVertical(col, row);

        //수직, 수평 검사
        CrossV();
        CrossH();

        // 수직 원래대로
        swapVertical(col, row);
    }

    public static void SwapH(int col, int row){
        if(row == len - 1) return;
        // 수평 swap
        swapHorizontal(col,row);

        // 수직, 수평 검사
        CrossV();
        CrossH();

        // 수평 원래대로
        swapHorizontal(col, row);
    }

    public static void swapHorizontal(int col, int row){
        char temp = map[col][row];
        map[col][row] = map[col][row + 1];
        map[col][row + 1] = temp;
    }
    public static void swapVertical(int col, int row){
        char temp = map[col][row];
        map[col][row] = map[col + 1][row];
        map[col + 1][row] = temp;
    }
    public static void main(String[] args) throws IOException {
        len = Integer.parseInt(br.readLine());
        map = new char[len][len];
        for(int i = 0; i < len; i++){
            String temp = br.readLine();
            for(int j = 0; j < len; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        // n*n 행렬 입력 완료

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                SwapV(i, j);
                SwapH(i, j);
            }
        }

        bw.write(((MAX == 0) ? 0 : MAX + 1) + "");
        bw.close();
    }
}