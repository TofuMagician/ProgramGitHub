class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int[] temp = new int[right - left + 1];
        
        for(int i = 0; i < right - left + 1; i++){
            
            temp[i] = 0;
        }
        
        for(int i = left; i <= right; i++){
            
            int sqrt = (int)Math.sqrt(i);
            
            for(int j = 1; j <= sqrt; j++){
                
                if(i % j == 0){
                    temp[i - left]++;
                    
                    if(i / j != j) temp[i - left]++;
                }
            }
        }
        
        for(int i = 0; i < right - left + 1; i++){
            
            if(temp[i] % 2 == 0) answer += (i + left);
            else{ answer -= (i + left); }
            
        }
        
        return answer;
    }
}