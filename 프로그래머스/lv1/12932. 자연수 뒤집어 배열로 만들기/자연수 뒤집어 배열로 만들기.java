import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        Stack<Integer> stack = new Stack();
        
        String temp = new String();
        
        temp = n + "";
        
        for(char x : temp.toCharArray()){
            
            stack.push(x - '0');
            
        }
        
        int[] answer = new int[stack.size()];
        
        int i = 0;
        
        while(stack.size() != 0){
            
            answer[i] = stack.pop();
            i++;
        }
        
        return answer;
    }
}