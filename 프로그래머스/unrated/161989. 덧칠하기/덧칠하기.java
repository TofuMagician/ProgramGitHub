import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        int answer = 0;
        
        ArrayList<Integer> array = new ArrayList<Integer>();
   
        for(int i = 0; i < n; i++){
            
            array.add(i + 1);
        }
        
        for(int x : section){
            if(array.contains(x)){
                for(int i = 0; i < m; i++){
                    if(array.contains(x+i)) array.remove(array.indexOf(x + i)); 
                }
                
                answer++;
            }
        }
        
        return answer;
    }
}