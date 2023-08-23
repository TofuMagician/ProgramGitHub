import java.util.*;

class Solution {
    
    public int funcMath(String sentence){
        
        if(sentence.equals("*")) return -2;
        else if(sentence.equals("#")) return -1;
        else{
            sentence = sentence.replace("S", "mS");
            sentence = sentence.replace("D", "mD");
            sentence = sentence.replace("T", "mT");
            
            String[] word = sentence.split("m");
            
            int num = Integer.parseInt(word[0]);
            
            if(word[1].equals("S")) return num;
            if(word[1].equals("D")) return num*num;
            if(word[1].equals("T")) return num*num*num;
        }
        
        return 0;
    }
    
    public int solution(String dartResult) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        dartResult = dartResult.replace("*", "*m");
        dartResult = dartResult.replace("S", "Sm");
        dartResult = dartResult.replace("D", "Dm");
        dartResult = dartResult.replace("T", "Tm");
        dartResult = dartResult.replace("#", "#m");
        
        String[] sentence = dartResult.split("m");
        
        int[] num = new int[sentence.length];
        
        for(int i = 0; i < sentence.length; i++){ 
            
            num[i] = funcMath(sentence[i]); 
        }
        int level = 0;
        
        for(int t : num){
            
            stack.push(t);
            
            if(t == -1){
                stack.pop();
                stack.push(stack.pop() * -1);
            }
            
            if(t == -2){
                stack.pop();
                if(level == 1){
                    stack.push(stack.pop() * 2);
                }
                else{
                    int temp = stack.pop();
                    stack.push(stack.pop() * 2);
                    stack.push(temp * 2);
                }
            }
            
            level++;
        }
      
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        
        return answer;
    }
}