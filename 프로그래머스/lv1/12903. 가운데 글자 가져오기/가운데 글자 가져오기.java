class Solution {
    public String solution(String s) {
        String answer = new String();
        
        if(s.length() % 2 == 0){
            
            answer += s.substring(s.length()/2 - 1, s.length()/2 + 1); 
        }
        
        else{
            
            answer += s.substring((int)s.length()/2, (int)s.length()/2 + 1);
        }
        
        return answer;
    }
}