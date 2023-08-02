import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n){
     
        String[] answer = new String[strings.length];
        ArrayList<String> array = new ArrayList<>();
        ArrayList<String> array_second = new ArrayList<>();
        HashMap<String, Integer> hmap = new HashMap<>();
        TreeMap<String, String> tmap = new TreeMap<>();
        
        for(String str : strings){
            str = str.substring(n, n+1);
            hmap.put(str, hmap.getOrDefault(str, 0) + 1);
        }
        
        for(String str : hmap.keySet()){
            
            if(hmap.get(str) > 1){
                
                array.add(str);
            }
            
            else{
                
                array_second.add(str);
            }
        }
        
        int k = array.size() + array_second.size();
        
        String[] temp = new String[k];
        
        for(int i = 0; i < k; i++){
            
            temp[i] = "";
        }
        
        
        int level = 0;
        
       
        for(String str : array){
            for(int i = 0; i < strings.length; i++){
                if(strings[i].substring(n, n + 1).equals(str)) temp[level] += strings[i] + " ";
            }
            level++;
        }
        
        for(String str : array_second){
            for(int i = 0; i < strings.length; i++){
                if(strings[i].substring(n, n + 1).equals(str)) temp[level] += strings[i];
                
            }
            level++;
        }
        
        
        for(String str : temp){
            
            tmap.put(str.substring(n , n+1), str);
        }
        
        int lev = 0;
        
        for(String str : tmap.keySet()){
        
            if(tmap.get(str).contains(" ")){
                
                String[] temp_str = tmap.get(str).split(" ");
                
                Arrays.sort(temp_str);
                
                for(String str1 : temp_str){
                    
                    answer[lev] = str1;
                    lev++;
                }
            }
            
            else{
                answer[lev] = tmap.get(str);
                lev++;
            }
        }
       
        return answer;
    }
}