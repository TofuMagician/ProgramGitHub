import java.util.*;
public class Main {
    static int size, count, stop, answer, show;
    static List<List<Integer>> array = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void Dynamic(int start){
        count = 0;
        array.add(new ArrayList<>());
        array.get(count).add(start);
        stop = 0;
        // 초기화
        while(true){
            answer = Integer.MAX_VALUE;
            for(int temp : array.get(count)){
                if(temp == size) {
                    show = count;
                    stop++;
                    break;
                }
                answer = Math.min(answer, temp);
                if(answer > size){
                    show = -1;
                    stop++;
                    break;
                }
            }
            if(stop > 0) break;
            array.add(new ArrayList<>());
            count++;
            array.get(count).add(array.get(count - 1).get(0) + 3);
            for(int i = 0; i < array.get(count - 1).size() - 1; i++){
                if(array.get(count - 1).get(i) + 5 == array.get(count - 1).get(i + 1) + 3){
                    array.get(count).add(array.get(count - 1).get(i) + 5);
                }
            }
            array.get(count).add(array.get(count - 1).get(array.get(count - 1).size() - 1) + 5);
        }
    }
    public static void main(String[] args) {
        size = sc.nextInt();
        Dynamic(0);
        System.out.println(show);
    }
}