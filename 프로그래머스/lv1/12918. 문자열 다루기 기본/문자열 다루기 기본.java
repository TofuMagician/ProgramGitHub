import java.util.*;

class Solution {
    
    public boolean isNumeric(String str){
        
        try{
            Integer.parseInt(str);
                return true;
        }
        
        catch(Exception e){
            
            return false;
        }
        
    }
    public boolean solution(String s) {
        
        if(isNumeric(s)){
            if(s.length() == 4 || s.length() == 6) return true;
        }
        
        return false;
    }
}