import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> map_first = new HashMap<>();
        Map<Character, Integer> map_second = new HashMap<>();
        Map<Character, Integer> map_third = new TreeMap<>(Collections.reverseOrder());
        
        for(char temp : X.toCharArray()){
            
            map_first.put(temp, map_first.getOrDefault(temp, 0) + 1);
        }
        
        for(char temp : Y.toCharArray()){
            
            map_second.put(temp, map_second.getOrDefault(temp, 0) + 1);
        }
        
        for(char temp : map_first.keySet()){
            
            if(map_first.containsKey(temp) && map_second.containsKey(temp)) map_third.put(temp, Math.min(map_first.get(temp), map_second.get(temp)));
            
        }
        
        if(map_third.size() == 0) return "-1";
        
        int j = 0;
        
        for(char temp : map_third.keySet()){
            
            if(j == 0 && temp == '0') return "0";
            if(map_third.get(temp) == 0) answer.append(temp);
            else{
                for(int i = 0; i < map_third.get(temp); i++){
                    answer.append(temp);
                }
            }
            
            j++;
        }
        
        String ans = answer.toString();
        
        return ans;
    }
}