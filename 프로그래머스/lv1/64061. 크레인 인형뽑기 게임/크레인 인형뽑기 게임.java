import java.util.*;

// 4 -> 3 -> 1 -> 1 -> 3 -> 2 -> x -> 4 (this is exmaple of pic)
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int temp : moves){
            temp--;
            for(int i = 0; i < board.length; i++){
                if(board[i][temp] != 0){
                    if(stack.size() > 0 && stack.peek() == board[i][temp]){
                        stack.pop();
                        answer++;
                    }
                    else{stack.push(board[i][temp]);}
                    
                    board[i][temp] = 0;
                    break;
                }
            }
        }
        
        
        return answer * 2;
    }
}