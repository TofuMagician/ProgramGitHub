import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        ArrayList<Integer> array = new ArrayList<>();
        for(int x : citations) array.add(x);
        Collections.sort(array, Collections.reverseOrder());
        array.add(0);
        
        for(int i = 1; i < array.size(); i++){
            
            if(array.get(i) <= i){
                
                if(array.get(i - 1) >= i) return i;
            }
        }
        
        return 0;
    }
}