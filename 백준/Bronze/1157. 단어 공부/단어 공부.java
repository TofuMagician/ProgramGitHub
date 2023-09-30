import java.util.*;
public class Main {
    static int compare = Integer.MIN_VALUE;
    static char hint;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder str = new StringBuilder();
    static Map<Character, Integer> map = new HashMap<>();
    static int level;
    public static void main(String[] args){

        str.append(sc.next().toUpperCase());
        level = 0;

        for(char temp : str.toString().toCharArray()) map.put(temp, map.getOrDefault(temp, 0) + 1);

        for(char temp : map.keySet()){

            compare = Math.max(compare, map.get(temp));
        }

        for(char temp : map.keySet()){
            if(map.get(temp) == compare){
                level++;
                hint = temp;
            }
        }

        if(level > 1) System.out.println("?");
        else{ System.out.println(hint); }
    }
}