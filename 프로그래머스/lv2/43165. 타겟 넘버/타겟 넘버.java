class Solution {
    
    private int ans = 0;
    
    public int DFS(int[] numbers, int target, int L, int sum){
        
        if(L == numbers.length) {
            if(target == sum){ 
                ans++;
                return 0;
            }
            else{
                return 0;
            }
        }

        
        DFS(numbers, target, L+1, sum + numbers[L]);
        DFS(numbers, target, L+1, sum - numbers[L]);
        
        return ans;
        
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = DFS(numbers, target, 0, 0);
        
        return answer;
    }
}