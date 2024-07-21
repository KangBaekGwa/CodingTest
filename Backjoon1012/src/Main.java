import java.util.Scanner;

public class Main {

    static int testCaseCnt;
    static int n, m, bug, resultCnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        testCaseCnt = sc.nextInt();

        for(int cnt=0; cnt<testCaseCnt; cnt++) {
            resultCnt = 0;
            m = sc.nextInt(); //칸, 가로
            n = sc.nextInt(); //줄, 세로
            bug = sc.nextInt(); //줄, 세로

            map = new int[n][m];
            visited = new boolean[n][m];
            sc.nextLine();

            for (int i = 0; i < bug; i++) {
                int x = sc.nextInt(); //칸, 가로
                int y = sc.nextInt(); //줄, 세로

                map[y][x] = 1;
            }

            for(int y=0; y<n; y++){
                for(int x=0; x<m; x++){
                    if(map[y][x] != 0 && !visited[y][x]){
                        dfs(y, x);
                        resultCnt++;
                    }
                }
            }

            System.out.println(resultCnt);
        }
    }

    public static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(visited[ny][nx]) continue;
            if(map[ny][nx] == 0) continue;

            dfs(ny, nx);
        }
    }
}