class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n < 2) return 1;
        
        int[] array = new int[n + 1];
        
        for(int i = 0; i < n; i++){
            array[i] = i + 1;
        }
        
        int l = 0;
        int r = 0;
        int sum = 0;
        
        while(l < n){
            
            if(sum >= n){
                sum -= array[l];
                l++;
            }
            
            else{
                
                sum += array[r];
                r++;
            }
            
            if(sum == n) answer++;
        }
        
        return answer;
    }
}