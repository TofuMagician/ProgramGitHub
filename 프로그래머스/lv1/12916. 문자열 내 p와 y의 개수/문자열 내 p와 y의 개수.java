class Solution {
    boolean solution(String s) {
      
        s = s.toLowerCase();
        
        int sum_1 = 0;
        int sum_2 = 0;
        
        for(char x : s.toCharArray()){
            if(x == 'p') sum_1++;
            if(x == 'y') sum_2++;
        }
        
        if(sum_1 == sum_2) return true;
        else{ return false;}

    }
}