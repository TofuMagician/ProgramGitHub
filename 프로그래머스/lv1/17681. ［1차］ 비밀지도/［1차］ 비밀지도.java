class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[] temp = new int[n]; 
        int[] temp2 = new int[n];
        int[] temp3 = new int[n];
        
        for(int i = 0; i < n; i++){
            
            for(int j = n - 1; j >= 0; j--){
                
                temp[j] = arr1[i] % 2;
                arr1[i] /= 2;
                temp2[j] = arr2[i] % 2;
                arr2[i] /= 2;
                
                if(temp[j] + temp2[j] != 0){
                 
                    temp3[j] = 1;
                }
                
                else{
                    
                    temp3[j] = 0;
                }    
            }
            
            answer[i] = "";
            
            for(int x : temp3){
                
                if(x == 1){
                    
                    answer[i] += "#";
                }
                
                else{
                    
                    answer[i] += " ";
                }
            }
        }
        
        return answer;
    }
}