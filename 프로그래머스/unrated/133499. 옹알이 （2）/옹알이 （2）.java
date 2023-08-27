class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sentence = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j <sentence.length; j++){
                
                babbling[i] = babbling[i].replace(sentence[j], j + "");
            }
        }
        
        for(String temp : babbling){
            try{
                Integer.parseInt(temp);
                String[] ch = temp.split("");
            
                for(int i = 0; i < ch.length - 1; i++){
                    if(ch[i].equals(ch[i + 1])) break;
                    if(i == ch.length - 2) answer++;
                } 
                
                if(temp.length() == 1) answer++;
            }
            
            catch(Exception e){}
        }
        
        return answer;
    }
}