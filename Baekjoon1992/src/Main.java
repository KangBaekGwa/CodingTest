import java.util.*;

public class Main {
    static int size;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        map = new int[size][size];

        for(int i=0; i<size; i++) {
            String temp = sc.next();
            for(int j=0; j<size; j++){
                map[i][j] = (int)temp.charAt(j) - '0';
            }
        }
        sc.close();


    }
}