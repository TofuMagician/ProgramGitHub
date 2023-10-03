import java.util.*;
import java.io.*;
public class Main {
    static int number;
    static int MAX;
    static List<List<Integer>> array = new ArrayList<>();
    static List<List<Integer>> visited = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException{

        number = Integer.parseInt(br.readLine());
        if(number == 1){
            bw.write(Integer.parseInt(br.readLine()) + "");
            bw.flush();
            bw.close();
            return;
        }

        for(int i = 0; i < number; i++){
            array.add(new ArrayList<>());
            visited.add(new ArrayList<>());
        }

        for(int i = 0; i < number; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                array.get(i).add(Integer.parseInt(st.nextToken()));
                visited.get(i).add(0);
            }
        }
        visited.get(0).set(0, array.get(0).get(0));

        for(int i = 1; i < number; i++){
            for(int j = 0; j < array.get(i).size(); j++){
                if(j == 0){
                    visited.get(i).set(0, array.get(i).get(0) + visited.get(i - 1).get(0));
                }
                else if(j == array.get(i).size() - 1){
                    visited.get(i).set(j, array.get(i).get(j) + visited.get(i - 1).get(j - 1));
                }
                else {
                    MAX = Integer.MIN_VALUE;
                    for (int k = j; k - j < 2; k++){
                        MAX = Math.max(MAX, visited.get(i-1).get(k-1));
                    }
                    visited.get(i).set(j, array.get(i).get(j) + MAX);
                }
            }
        }

        for(int temp : visited.get(array.size() - 1)) pqueue.offer(temp);

        bw.write(pqueue.poll() + "");
        bw.flush();
        bw.close();
    }
}