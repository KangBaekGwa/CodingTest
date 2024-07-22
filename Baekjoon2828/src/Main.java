 import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mapSize = sc.nextInt();
        int boxSize = sc.nextInt() - 1;
        int targetCount = sc.nextInt();
        int totalCount = 0;

        int nowPos = 1;
        int canPos = nowPos + boxSize;

        for(int i=0; i<targetCount; i++){
            int nowDropPos = sc.nextInt();
            int nowCnt = 0;
            while(nowPos > nowDropPos || nowDropPos > canPos){
                if(nowPos > nowDropPos){ //왼쪽 이동해야 하는 경우
                    nowPos--;
                    canPos--;
                } else if (nowDropPos > canPos) { //오른쪽으로 이동해야 하는 경우.
                    nowPos++;
                    canPos++;
                }
                nowCnt++;
            }
            totalCount += nowCnt;
        }

        System.out.println(totalCount);
    }
}