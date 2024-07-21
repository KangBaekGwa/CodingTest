import java.util.*;

public class Main {
    static boolean[][] map; //true 일 경우, 사각형이 쳐진 부분.
    static boolean[][] visited;
    static int maxY, maxX, K; //M = y, N = x, K = cnt;
    static int dfsCnt;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxY = sc.nextInt();
        maxX = sc.nextInt();
        K = sc.nextInt();

        map = new boolean[maxY][maxX];
        visited = new boolean[maxY][maxX];

        for(int i=0; i<K; i++){
            int x1, x2, y1, y2;
            x1 = sc.nextInt(); // 0
            y1 = sc.nextInt(); // 2
            x2 = sc.nextInt(); // 4
            y2 = sc.nextInt(); // 4

            for(int x=x1; x<x2; x++){
                for(int y=y1; y<y2; y++){
                    map[y][x] = true;
                }
            }
        }

        int cnt = 0;
        List<Integer> size = new ArrayList<>();

        for(int y=0; y<maxY; y++){
            for(int x=0; x<maxX; x++){
                if(map[y][x] == false && visited[y][x] == false){
                    dfsCnt = 0;
                    dfs(y, x);

                    size.add(dfsCnt);
                    cnt++;
                }
            }
        }

        Collections.sort(size);
        System.out.println(cnt);
        for(int i=0; i<cnt; i++){
            System.out.print(size.get(i));
            if(i+1 != cnt) System.out.print(" ");
        }
    }

    private static void dfs(int y, int x){
        visited[y][x] = true;
        dfsCnt++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= maxX || ny >= maxY) continue;
            if(map[ny][nx] == true) continue;
            if(visited[ny][nx] == true) continue;

            dfs(ny, nx);
        }
    }
}