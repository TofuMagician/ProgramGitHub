class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        String temp = new String();
        int sum = 0;
        
        temp = x + "";
        
        for(char ch : temp.toCharArray()){
            
            sum += ch - '0';
        }
        
        if(x % sum == 0) return true;
        
        return answer;
    }
}