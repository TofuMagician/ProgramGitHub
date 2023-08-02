import java.util.*;

class Solution {
    public Integer[] solution(int[] numbers) {
        
        Set<Integer> tset = new TreeSet<>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                
                if(i != j) tset.add(numbers[i] + numbers[j]);
            }
        }
        
        Integer[] answer = new Integer[tset.size()];
        
        answer = tset.toArray(new Integer[0]);
        
        return answer;
    }
}