class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int length = number.length;
        int l = 0;
        int total = 0;
        
        for(int i = 0; i < length - 2; i++){
            
            for(int j = i + 1; j < length - 1; j++){
                
                for(int k = j + 1; k < length; k++){
                    
                    total = number[i] + number[j] + number[k];
                    
                    if(total == 0){
                        
                        l++;
                        
                    }
                }
                
            }
            
        }
        
        answer = l;
        
        return answer;
    }
}