import java.util.*;

class Solution {
    
    public int func(int temp){
        if(temp == 6) return 1;
        if(temp == 5) return 2;
        if(temp == 4) return 3;
        if(temp == 3) return 4;
        if(temp == 2) return 5;
        if(temp <= 1) return 6;
        
        return 0;
    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count_first = 0;
        int count_second = 0;
        
        List<Integer> array_lottos = new ArrayList<>();
        
        for(int temp : lottos){
            if(temp == 0) count_first++;
            else{
                array_lottos.add(temp);
            }
        }
        
        for(int temp : win_nums){
            if(array_lottos.contains(temp)) count_second++;
        }
        
        
        answer[0] = func(count_first + count_second);
        answer[1] = func(count_second);
        
        
        return answer;
    }
}