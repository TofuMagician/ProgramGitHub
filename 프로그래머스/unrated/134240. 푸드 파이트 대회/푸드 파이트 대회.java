class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i = 1; i < food.length; i++){
            
            if(food[i] % 2 == 1){
                
                food[i] -= 1;
            }
            
            food[i] /= 2;
        }
        
        for(int i = 1; i < food.length; i++){
            int j = 0;
            
            while(j < food[i]){
                
                answer += String.valueOf(i);
                j++;
            }
        }
        
        StringBuffer reverse = new StringBuffer(answer);
        
        answer += "0";
        answer += reverse.reverse();
        
        return answer;
    }
}