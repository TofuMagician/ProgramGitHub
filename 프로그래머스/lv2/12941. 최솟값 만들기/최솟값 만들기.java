import java.util.*;


// 그리디탐색법 이용

class Solution
{
    public int solution(int []A, int []B){
        
        int answer = 0;
        int len = A.length;
        
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int x : A){
            a.add(x);
        }
        for(int x : B){
            b.add(x);
        }
        
        for(int i = 0; i < len; i++){
            
            answer += a.poll() * b.poll();
        }
        
        

        return answer;
    }
}