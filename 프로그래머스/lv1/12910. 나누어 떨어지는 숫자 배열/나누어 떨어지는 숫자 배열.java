import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        
        for(int x : arr){
            
            if(x % divisor == 0) pqueue.offer(x);
        }
        
        int level = 0;
        
        if(pqueue.size() == 0) pqueue.offer(-1);
        
        int[] answer = new int[pqueue.size()];
        
        while(pqueue.size() != 0){
            
            answer[level] = pqueue.poll();
            level++;
        }
        
        return answer;
    }
}