import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int[] temp_1 = new int[progresses.length];
        boolean[] temp_2 = new boolean[progresses.length];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            
            temp_1[i] = ((100 - progresses[i]) / speeds[i]);
            
            if((100 - progresses[i]) % speeds[i] == 0) temp_2[i] = true;
            else{temp_2[i] = false;}
            
            if(temp_2[i]) queue.offer(temp_1[i]);
            else{ queue.offer(temp_1[i] + 1);}
            
        }
        
        int temp_3 = queue.poll();
        int L_1 = 1;
        
        queue.offer(Integer.MAX_VALUE);
        
        while(!queue.isEmpty()){
            if(temp_3 >= queue.peek()){
                queue.poll();
                L_1++;
            }
            else{
                array.add(L_1);
                L_1 = 1;
                temp_3 = queue.poll();
            }
        }
        
        int[] answer = new int[array.size()];
        
        for(int i = 0; i < array.size(); i++){
            
            answer[i] = array.get(i);
        }
        
        return answer;
    }
}