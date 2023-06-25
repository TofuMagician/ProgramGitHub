class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int num = t.length() - p.length() + 1;
        Long[] arr = new Long[num];
        long j = Long.parseLong(p);
        int l = p.length();
        ////////////////////////////////////////////
        for(int i = 0; i < num; i++){
            arr[i] = Long.parseLong(t.substring(i, i + l));
            if(arr[i] <= j) answer++;
        }
        
        return answer;
    }
}