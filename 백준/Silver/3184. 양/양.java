import java.util.*;
import java.io.*;
public class Main {
    static int col, row, sheep, wolf, leftSheep, leftWolf, sumOfSheep, sumOfWolf;
    static char[][] map;
    static boolean[][] visited;
    static List<Integer[]> array = new ArrayList<>();
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer str;
    public static void DFS(int reCol, int reRow){
        visited[reCol][reRow] = true;
        if(map[reCol][reRow] == 'v') wolf = wolf + 1;
        if(map[reCol][reRow] == 'o') sheep = sheep + 1;

        for(int i = 0; i < dx.length; i++){
            int newCol = reCol + dy[i];
            int newRow = reRow + dx[i];
            if(newCol >= 0 && newCol < col && newRow >= 0 && newRow < row){
                if (!visited[newCol][newRow] && map[newCol][newRow] != '#'){
                    DFS(newCol, newRow);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        str = new StringTokenizer(br.readLine());
        col = Integer.parseInt(str.nextToken());
        row = Integer.parseInt(str.nextToken());
        map = new char[col][row];
        visited = new boolean[col][row];

        for(int i = 0; i < col; i++){
            int level = 0;
            for(char temp : br.readLine().toCharArray()){
                map[i][level] = temp;
                level++;
            }
        }

        // DFS 완탐
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if(!visited[i][j] && map[i][j] != '#'){
                    sheep = 0;
                    wolf = 0;
                    leftSheep = 0;
                    leftWolf = 0;

                    DFS(i, j);
                    if(sheep > wolf){
                        leftSheep = sheep;
                        wolf = 0;
                    }
                    else{
                        leftSheep = 0;
                        leftWolf = wolf;
                    }
                    array.add(new Integer[] {leftSheep, leftWolf});
                }
            }
        }

        sumOfSheep = 0;
        sumOfWolf = 0;

        for(int i = 0; i < array.size(); i++){
            sumOfSheep += array.get(i)[0];
            sumOfWolf += array.get(i)[1];
        }

        bw.write(sumOfSheep + " " + sumOfWolf);
        bw.flush();
        bw.close();
    }
}