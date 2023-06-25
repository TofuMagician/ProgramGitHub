class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int number = 0;
        int trash = 0;
        int total = n;
        int add = 0;
        
        while(total >= a){
            
            number = n / a;
            trash = n % a;
            total = trash + (b * number);
            n = total;
            add += (b * number);
            
        }
        
        answer = add;
        
        return answer;
    }
}