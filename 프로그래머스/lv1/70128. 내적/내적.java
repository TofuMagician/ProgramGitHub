class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        if(a.length != b.length) return -1;
        
        for(int i = 0; i < a.length; i++){
            
            answer += a[i] * b[i];
        }
        
        return answer;
    }
}