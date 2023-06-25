import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 1;
        int temp;
        
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> array1 = new ArrayList<>();
        

        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }    
        }
        
        
        for(int i = 0; i < sizes.length; i++){
            
            array.add(sizes[i][0]);
        }
        
        
        
        for(int i = 0; i < sizes.length; i++){
            
            array1.add(sizes[i][1]);
        }
        
        
        
        Collections.sort(array);
        Collections.sort(array1);
        
        int a1 = array.get(array.size() - 1);
        
        int a2 = array1.get(array1.size() - 1);
        
        return answer = a1 * a2;
    }
}