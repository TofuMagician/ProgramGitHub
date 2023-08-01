import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = -1;
        double temp = Math.sqrt(n);
        
        if(temp % 1 == 0) return (long)((temp+1)*(temp+1));
     
        return answer;
    }
}