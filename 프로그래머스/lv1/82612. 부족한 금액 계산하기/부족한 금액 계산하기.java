class Solution {
    public long solution(int price, long money, int count) {
    
        for(int i = 0; i < count; i++){
        
            money -= ((i + 1) * price);
        }
        
        if(money >= 0) return 0;
        
        return money*(-1);
    }
}