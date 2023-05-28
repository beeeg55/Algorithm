package sort.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_16173 {
    static int[] dr = {1,0};
    static int[] dc = {0,1};
    static int[][] map;
    static boolean[][] visit;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        // map 입력받기
        for (int i = 0; i<N; i++){
            String s = br.readLine();
            st = new StringTokenizer(s, " ");
            for (int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean result = bfs();
        if(result){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }
    }

    public static boolean bfs(){
        boolean reach = false;
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {0,0});
        visit[0][0] = true;
        while(!qu.isEmpty()){
            int[] temp = qu.poll();
            for (int i = 0; i<2; i++){
                int num = map[temp[0]][temp[1]];
                int r = temp[0] + dr[i]*num;
                int c = temp[1] + dc[i]*num;
                // 범위 체크 - 오른쪽과 아래로만 방향이 있기때문에 위경계만 체크
                if(isRange(r,c) && !visit[r][c]){
                    if(r==N-1 && c==N-1){
                        return true;
                    }else{
                        visit[r][c] = true;
                        qu.add(new int[] {r,c});
                    }
                }
            }
        }
        return reach;
    }

    public static boolean isRange(int r, int c){
        if(r<N&&c<N){
            return true;
        }
        return false;
    }
}
