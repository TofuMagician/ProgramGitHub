import java.util.*;
public class Main {
    static int repeat;
    static StringBuilder str = new StringBuilder();
    static Stack<Character> stack = new Stack<>();
    static Scanner sc = new Scanner(System.in);
    static List<String> array = new ArrayList<>();
    public static void main(String[] args){

        repeat = sc.nextInt();

        for(int i = 0; i < repeat; i++){
            str.append(sc.next());

            int length = str.length();

            for(int j = 0; j < length; j++){
                char temp = str.charAt(j);
                if(temp == ')' && stack.isEmpty()){
                    stack.push('1');
                    break;
                }
                if(!stack.isEmpty() && stack.peek() != temp) stack.pop();
                if(temp == '(') stack.push(temp);

            }

            if(stack.isEmpty()) array.add("YES");
            else{
                array.add("NO");
                stack.clear();
            }
            str.setLength(0);
        }
        for(String temp : array) System.out.println(temp);
    }
}