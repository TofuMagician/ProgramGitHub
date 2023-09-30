import java.util.*;
public class Main {
    static int repeat, number;
    static StringBuilder str = new StringBuilder();
    static StringBuilder answer = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        repeat = sc.nextInt();
        for(int i = 0; i < repeat; i++){
            number = sc.nextInt();
            str.append(sc.next());
            int level = str.length();
            for(int j = 0; j < level; j++){
                char temp = str.charAt(j);
                for(int k = 0; k < number; k++){
                    answer.append(temp);
                }
            }
            answer.append(" ");
            str.setLength(0);
        }
        StringTokenizer split = new StringTokenizer(answer.toString());

        while(split.hasMoreTokens()) System.out.println(split.nextToken());
    }
}