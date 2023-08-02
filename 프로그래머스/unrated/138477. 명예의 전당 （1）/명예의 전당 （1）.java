import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        
        int level = 0;
        
        for(int arr : score){
            
            pqueue.offer(arr);
            
            System.out.print(pqueue.peek() + " ");
            if(level < k) answer[level] = pqueue.peek();
            else{
                pqueue.poll();
                answer[level] = pqueue.peek();
            }
            level++;
        }
        
        return answer;
    }
}