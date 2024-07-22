import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int maxValue = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int[] appear = new int[size]; //[1] = 2 --> 1번 이 2번째로 등장.

        for(int cnt=0; cnt<size; cnt++){
             int nowValue = sc.nextInt();
             if(map.containsKey(nowValue) == true){
                 map.put(nowValue, map.get(nowValue)+1);
             }
             else{
                 map.put(nowValue, 1);
             }

             if(appear[nowValue] == 0){
                 appear[nowValue] = cnt;
             }
        }

        sc.close();
    }
}