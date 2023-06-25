import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> card_one = new LinkedList<>();
        Queue<String> card_two = new LinkedList<>();
        Queue<String> array = new LinkedList<>();
        
        for(String x : cards1){
            
            card_one.add(x);
        }
        
        for(String x : cards2){
            
            card_two.add(x);
        }
        
        for(String x : goal){
            
            array.add(x);
        }
        
        for(String x : goal){
            
            if(x.equals(card_one.peek())) {card_one.poll(); array.poll();}
            if(x.equals(card_two.peek())) {card_two.poll(); array.poll();}
        }
        
        if((card_one.size() == 0 && card_two.size() == 0) || array.size() == 0) return "Yes";
        else return "No";

    }
}