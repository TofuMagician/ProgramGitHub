import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int x : d){
            temp.add(x);
        }
        
        Collections.sort(temp);
        
        for(int x : temp){
            
            budget = budget - x;
            
            if(budget < 0){
                
                return answer;
            }
            
            answer++;
        }
        return answer;
    }
}