import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        
        PriorityQueue<Character> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        
        String temp = new String();
        String reverse = new String();
        temp = n + "";
        
        for(char x : temp.toCharArray()){
            
            pqueue.offer(x);
        }
        
        while(pqueue.size() != 0){
            
            reverse += pqueue.poll();
        }
        
        answer = Long.parseLong(reverse);
        
        return answer;
    }
}