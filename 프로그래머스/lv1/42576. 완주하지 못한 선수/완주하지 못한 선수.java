import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = new String();
        Map<String, Integer> mapFirst = new HashMap<>();
        
        for(String temp : participant) mapFirst.put(temp, mapFirst.getOrDefault(temp, 0) + 1);
        for(String temp : completion) mapFirst.put(temp, mapFirst.getOrDefault(temp, 0) + 1);
        
        for(String temp : mapFirst.keySet()){
            if(mapFirst.get(temp) % 2 != 0){
                answer+= temp;
            }
        }
        
        
        return answer;
    }
}