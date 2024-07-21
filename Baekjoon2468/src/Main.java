import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] nowMap;
    static boolean[][] visited;
    static int maxValue = 0; //최대 높이
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int totalCnt = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                map[y][x] = sc.nextInt();
                maxValue = Math.max(maxValue, map[y][x]);
            }
        }

        //물에 잠기기
        for(int wave=1; wave<maxValue; wave++){
            nowMap = new int[N][N];
            visited = new boolean[N][N];

            //잠기는 곳 map으로 표기.
            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    //잠기는 곳보다 높으면 값 넣고, 아니면 0으로 초기화.
                    nowMap[y][x] = map[y][x] > wave ? map[y][x] : 0;
                }
            }

            int nowCnt = 0;
            //안전지역 카운트 확인.
            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++) {
                    if(nowMap[y][x] != 0 && visited[y][x] == false) {
                        dfs(y, x);
                        nowCnt++;
                    }
                }
            }

            totalCnt = Math.max(totalCnt, nowCnt);
        }

        System.out.println(totalCnt);
    }

    private static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(nowMap[ny][nx] == 0) continue;
            if(visited[ny][nx] == true) continue;

            dfs(ny, nx);
        }
    }
}