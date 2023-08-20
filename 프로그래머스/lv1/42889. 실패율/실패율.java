import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        TreeMap<Integer, Double> tmap_1 = new TreeMap<>();
        PriorityQueue<Double> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < stages.length; i++){
            if(stages[i] == N + 1){}
            else{
                tmap.put(stages[i], tmap.getOrDefault(stages[i], 0) + 1);
            }
        }
        
        double size_tmap = stages.length;
        
        for(int i = 1; i <= N; i++){
           
            if(!tmap.containsKey(i)) tmap_1.put(i, 0.0);
            else{
                tmap_1.put(i, (tmap.get(i) / size_tmap));
                size_tmap -= tmap.get(i);
            }
        }
        
        for(int t : tmap_1.keySet()){
            
            System.out.println(t + " " + tmap_1.get(t));
        }
        
        ArrayList<Integer> keys = new ArrayList<>(tmap_1.keySet());
        Collections.sort(keys, (v1, v2) -> tmap_1.get(v2).compareTo(tmap_1.get(v1)));
        
        int level = 0;
        
        for(int t : keys){
            
            answer[level] = t;
            level++;
        }
        
    
        
        return answer;
    }
}