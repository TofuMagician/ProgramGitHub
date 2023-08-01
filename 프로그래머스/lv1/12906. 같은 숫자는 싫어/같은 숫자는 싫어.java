import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != stack.peek()) stack.push(arr[i]);
        }
        
        stack.remove(stack.indexOf(-1));
        int[] answer = new int[stack.size()];
        
        for(int i = stack.size() - 1; i >= 0 ; i--){
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}