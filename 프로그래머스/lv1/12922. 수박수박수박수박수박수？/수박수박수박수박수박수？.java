class Solution {
    public String solution(int n) {
        String answer = "";
        String[] string = new String[2];
        string[0] = "수";
        string[1] = "박";
        
        for(int i = 0; i < (int)(n/2); i++){
            
            answer += string[0];
            answer += string[1];
        }
        
        if(n % 2 != 0) answer += string[0];
        
        return answer;
    }
}