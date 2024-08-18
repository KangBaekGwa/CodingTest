
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] nextDelete;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int maxY;
    static int maxX;

    static int lastCheese = 0;

    public static void main(String[] args) {
        int totalCnt = 0;
        boolean isCheeseExist = false;

        Scanner sc = new Scanner(System.in);
        maxY = sc.nextInt();
        maxX = sc.nextInt();
        map = new int[maxY][maxX];
        nextDelete = new int[maxY][maxX];
        visited = new int[maxY][maxX];

        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                map[y][x] = sc.nextInt();

                if(map[y][x] == 1) isCheeseExist = true;
            }
        }

        if(!isCheeseExist){
            System.out.println(totalCnt);
            System.out.println(lastCheese);
            return;
        }

        while(true) {
            totalCnt++;

            //녹을것 계산.
            int sx = 0;
            int sy = 0;
            dfs(sy, sx);

            //녹을거 계산은 다 했고, 녹은거 반영해보기.
            boolean isComplete = melting();

            if(isComplete == true){
                System.out.println(totalCnt);
                System.out.println(lastCheese);
                return;
            }

            nextDelete = new int[maxY][maxX];
            visited = new int[maxY][maxX];
        }
    }

    private static boolean melting() {
        boolean flag = true;
        lastCheese = 0;

        for(int y=0; y<maxY; y++){
            for(int x=0; x<maxX; x++){
                if(nextDelete[y][x] == 1){
                    lastCheese++;
                    map[y][x] = 0;
                }
                if(map[y][x] == 1) flag = false;
            }
        }

        return flag;
    }

    private static void dfs(int y, int x){
        visited[y][x] = 1;

        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(ny < 0 || nx < 0 || nx >= maxX || ny >= maxY) continue; //오버/언더 플로우 방지
            if(visited[ny][nx] == 1) continue; //재방문 금지.
            if(map[ny][nx] == 1){
                //치즈가 있는 경우, 다음에 녹을것으로 예상하기.
                nextDelete[ny][nx] = 1;
                visited[ny][nx] = 1;
                continue;
            }
            dfs(ny, nx);
        }
    }
}