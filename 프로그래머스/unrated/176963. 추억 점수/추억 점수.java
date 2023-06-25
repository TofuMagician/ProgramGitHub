import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> pictures = new HashMap<String, Integer>();
        
        for(int i = 0; i < name.length; i++){
            
            pictures.put(name[i], yearning[i]);
            
        }
        
        for(int i = 0; i < photo.length; i++){
            
            int sum = 0;
            
            for(int j = 0; j < photo[i].length; j++){
                
                if(pictures.containsKey(photo[i][j])){
                    
                sum += (int) pictures.get(photo[i][j]);
                    
                }
            }
            
            answer[i] = sum;
    
        }
        
        return answer;
    }
}