import java.util.*;
import java.io.*;
public class Main {
    private static int[] parents;
    private static int repeat;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    public static int Find(int var){
        if(parents[var] == var) return var;
        return parents[var] = Find(parents[var]);
    }

    public static void Union(int...var){
        var[0] = Find(var[0]);
        var[1] = Find(var[1]);

        if(var[0] == var[1]) return;
        if(var[0] < var[1]) parents[var[1]] = var[0];
        else{
            parents[var[0]] = var[1];
        }
    }

    public static boolean isUnion(int...var){
        var[0] = Find(var[0]);
        var[1] = Find(var[1]);
        return var[0] == var[1];
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        parents = new int[Integer.parseInt(st.nextToken()) + 1];
        for(int i = 1; i < parents.length; i++) parents[i] = i;
        repeat = Integer.parseInt(st.nextToken());
        for(int i = 0; i < repeat; i++){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 0){
                Union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            else{
                if(true == isUnion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) bw.write("YES");
                else{
                    bw.write("NO");
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}