import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
     
        Stack<String> stackFirst = new Stack<>();
        
        int level = 0;
        
        for(char temp : s.toCharArray()){
            String str = temp + "";
            if(level == 0){
                stackFirst.push(str);
                level++;
                }
            else{
                if(!stackFirst.peek().equals(str)) stackFirst.pop();
                else{ stackFirst.push(str);}
                level++;
            }
            
            if(stackFirst.empty()){
                answer++;
                level = 0;
            }
        }
        
        if(!stackFirst.empty()) answer++;
        
        
        
        return answer;
    }
}