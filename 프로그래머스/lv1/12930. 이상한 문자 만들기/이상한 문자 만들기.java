class Solution {
    public String solution(String s) {
        
        s += "1";
        String answer = new String();
        String[] temp = s.split(" ");
        
        for(int i = 0; i < temp.length; i++){
            int level = 0;
            
            for(char x : temp[i].toCharArray()){
                
                if(level % 2 == 0) answer += Character.toUpperCase(x);
                else{ answer += Character.toLowerCase(x);}
                level++;
            }
        
            if(i != temp.length - 1)  answer += " ";
        }
        
        answer = answer.replaceAll("1", "");
        return answer;
    }
}