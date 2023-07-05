import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String, Integer> HMap = new HashMap<>();
        int ans = 0;
            
        int i = 0;
        
        while(i < words.length){
            
            HMap.put(words[i], HMap.getOrDefault(words[i], 0) + 1);
            
            if(HMap.get(words[i]) > 1){
                ans = i;
                break;
            }
                    
            if(!(i >= words.length - 1) && !(words[i].charAt(words[i].length() - 1) == words[i + 1].charAt(0))){
                ans = i + 1;
                break;
            }
            
            i++;
        }
        
        if(ans == 0){
            
            answer[0] = 0;
            answer[0] = 0;
            return answer;
        }
        
        answer[0] = (ans % n) + 1;
        answer[1] = (ans / n) + 1;
     
        return answer;
    }
}