import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> mapFirst = new HashMap<>();
        
        for(int i = 0; i < targets.length; i++) answer[i] = 0;
        
        for(int i = 0; i < keymap.length; i++){
            int level = 1;
            for(char temp : keymap[i].toCharArray()){
                String str = temp + "";
                if(mapFirst.containsKey(str)) mapFirst.put(str, Math.min(level, mapFirst.get(str)));
                else{mapFirst.put(str, level);}
                level++;
            }
        }
        
        for(int i = 0; i < targets.length; i++){
            for(char temp : targets[i].toCharArray()){
                String strSecond = temp + "";
                if(mapFirst.containsKey(strSecond)) answer[i] += mapFirst.get(strSecond);
                else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}