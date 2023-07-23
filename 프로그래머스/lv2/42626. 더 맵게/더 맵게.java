import java.util.*;

class Solution {
    public int solution(int[] scoville, long K) {
        
        PriorityQueue pqueue = new PriorityQueue();
        for(int x : scoville) pqueue.add(x);
        
        long sum = 0;
        int L = 0;
        int temp = 0;
       
        while((int)pqueue.peek() < K){
         
            if((int)pqueue.size() < 2) break;
            
            temp += (int)(pqueue.poll()) + (2 * (int)(pqueue.poll()));
            sum += temp;
            pqueue.offer(temp);
            temp = 0; 
            L++;
        }
    
        if(pqueue.size() == 1){
            if((int)pqueue.peek() < K) return -1;
        }
         
        
        return L;
    }
}