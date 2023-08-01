class Solution {
    public String solution(String phone_number) {
        String answer = new String();
        int len = phone_number.length();
        phone_number = phone_number.substring(phone_number.length() - 4, phone_number.length());
        
        for(int i = 0; i < len - 4; i++){
            
            answer += "*";
        }
        
        answer += phone_number;
        
        return answer;
    }
}