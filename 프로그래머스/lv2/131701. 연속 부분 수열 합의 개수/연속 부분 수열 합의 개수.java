import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int total = 0;
        
        
        
        ArrayList<Integer> array = new ArrayList<>();
        HashSet<Integer> hmap = new HashSet<>();
        
        for(int i = 0; i < 2; i++){
            for(int x : elements) array.add(x);
        }
        
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                
                int lf = j;
                
                while(lf < j + i){
                    
                    total += array.get(lf);
                    lf++;
                }
                
                hmap.add(total);
                total = 0;
            }
        }
        
        return answer = hmap.size();
    }
}