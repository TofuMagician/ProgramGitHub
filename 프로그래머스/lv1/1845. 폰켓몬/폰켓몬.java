import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int k = (nums.length / 2);
    
        HashMap<Integer, Integer> hmap = new LinkedHashMap<>();

        for(int i = 0; i < nums.length; i++){
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        
        Integer[] value = hmap.values().toArray(new Integer[0]);

        while(k != 0){
            for(int temp : hmap.keySet()){
                if(hmap.get(temp) > 0){
                    hmap.put(temp, hmap.getOrDefault(temp, 0) - 1);
                    k--;
                    if(k == 0) break;
                }
            }
        }
        
        Integer[] value_second = hmap.values().toArray(new Integer[0]);
        
        for(int i = 0; i < value_second.length; i++){
            
            if(value_second[i] != value[i]) answer++;
        }
        
        return answer;
    }
}