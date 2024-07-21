import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //줄, 세로
        m = sc.nextInt(); //칸, 가로
        map = new int[n][m];
        visited = new int[n][m];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(visited[n - 1][m - 1]);
    }

    public static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ y, x });
        visited[y][x] = 1;

        while( !queue.isEmpty() ){
            int[] nowPos = queue.poll();

            for(int i=0; i<4; i++) {
                int ny = nowPos[0] + dy[i];
                int nx = nowPos[1] + dx[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(visited[ny][nx] != 0) continue; // 0이 아니면, 이미 들린 곳.
                if(map[ny][nx] == 0) continue; //0은 갈 수 없다.

                //이제 갈수 있음 증명 확인 완료.
                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = visited[nowPos[0]][nowPos[1]] + 1;
            }
        }
    }
}