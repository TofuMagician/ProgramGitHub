import java.util.*;
public class Main {
    static int repeat, sum, level;
    static ArrayList<Integer> array = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        repeat = sc.nextInt();

        for(int i = 0; i < repeat; i++) {
            StringBuilder str = new StringBuilder();
            str.append(sc.next());
            int length = str.length();
            sum = 0;
            level = 0;
            for (int j = 0; j < length; j++) {
                if (str.charAt(j) == 'O') level++;
                else {
                    level = 0;
                }
                sum += level;
            }
            array.add(sum);
        }

        for(int temp : array) System.out.println(temp);
    }
}