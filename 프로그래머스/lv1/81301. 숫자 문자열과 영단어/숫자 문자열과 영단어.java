class Solution {
    public int solution(String s) {
        int answer = 0;
        String sentence = new String(s);
        
        sentence = sentence.replaceAll("zero", "0");
        sentence = sentence.replaceAll("one", "1");
        sentence = sentence.replaceAll("two", "2");
        sentence = sentence.replaceAll("three", "3");
        sentence = sentence.replaceAll("four", "4");
        sentence = sentence.replaceAll("five", "5");
        sentence = sentence.replaceAll("six", "6");
        sentence = sentence.replaceAll("seven", "7");
        sentence = sentence.replaceAll("eight", "8");
        sentence = sentence.replaceAll("nine", "9");
        sentence.trim();
        sentence.replaceAll(" ", "");
        
        answer = Integer.parseInt(sentence);
        
        return answer;
    }
}