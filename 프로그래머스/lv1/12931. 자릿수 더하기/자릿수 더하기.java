import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String ans = new String();
        
        ans += n + "";
        
        for(char x : ans.toCharArray()){
            answer += (x - '0');
        }

        return answer;
    }
}