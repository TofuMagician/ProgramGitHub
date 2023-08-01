import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = new String();
        
        PriorityQueue<Character> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(char string : s.toCharArray()){
            
            pqueue.offer(string);
        }
        
        while(pqueue.size() > 0){
            
            answer += pqueue.poll();
        }
        
        return answer;
    }
}