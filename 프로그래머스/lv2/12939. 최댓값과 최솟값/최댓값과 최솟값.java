import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
    
        s = s.replace("\"", "");
        String[] str = s.split(" ");
        
        ArrayList<Integer> array = new ArrayList<>();
        
        for(String x : str){
                
            array.add(Integer.parseInt(x));
            
        }
        
        Collections.sort(array);
        
        answer += array.get(0);
        answer += " ";
        answer += array.get(array.size() - 1);
        
        return answer;
    }
}