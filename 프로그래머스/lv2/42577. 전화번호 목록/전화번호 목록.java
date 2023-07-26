import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        StringBuffer sbuffer = new StringBuffer();
        StringBuffer temp_string = new StringBuffer();
        
        int i = 0;
        
        try{
            while(true){
                
                sbuffer.append(phone_book[i]);
                temp_string.append(phone_book[i + 1]);
                if(temp_string.length() < sbuffer.length()){}
                else{
                    if(temp_string.substring(0, sbuffer.length()).equals(sbuffer.toString())) return false;
                }
                sbuffer.delete(0, sbuffer.length());
                temp_string.delete(0, temp_string.length());
                i++;
            }  
        }
        
        catch(Exception e){
            
            return true;
        }
    }
}