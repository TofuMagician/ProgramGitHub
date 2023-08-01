import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> array = new ArrayList<>();
        
        for(int x : arr){
            
            array.add(x);
        }

        int sum = Integer.MAX_VALUE;
        
        for(int x : array){
            
            sum = Math.min(sum, x);
        }
        
        array.remove(array.indexOf(sum));
      
        if(array.size() == 0) array.add(-1);
        
        int[] answer = new int[array.size()];
        
        
        for(int i = 0; i < array.size(); i++){
            
            answer[i] = array.get(i);
        }

        return answer;
    }
}