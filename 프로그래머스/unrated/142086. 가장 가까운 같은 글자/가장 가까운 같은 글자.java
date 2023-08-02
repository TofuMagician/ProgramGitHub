import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] temp = new char[s.length()];
        
        int level = 0;
        
        for(char str : s.toCharArray()){
            
            temp[level] = str;
            level++;
        }
    
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                
                if(temp[i] == temp[j] && i != j){
                    answer[i] = i - j;
                    break;
                }
                
                else{
                    
                    if(j == 0) answer[i] = -1;
                }
            }
            
        
        }
        
        return answer;
    }
}