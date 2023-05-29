package sort.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1926 {
    static int n;
    static int m;
    static int max;

    static int[][] paper;
    static boolean[][] visit;

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int count = 0; // 그림의 개수
        max = 0;

        paper = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j]&&paper[i][j]==1){
                    count++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(int i, int j){
        int size = 1;
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[] {i,j});
        visit[i][j] = true;
        while(!qu.isEmpty()){
            int[] temp = qu.poll();
            for(int index = 0; index < 4; index++){
                int r = temp[0] + dr[index];
                int c = temp[1] + dc[index];
                if(0<=r&&r<n&&0<=c&&c<m&&!visit[r][c]&&paper[r][c]==1){
                    size++;
                    visit[r][c] = true;
                    qu.add(new int[] {r,c});
                }
            }
        }
        if(size>max){
            max = size;
        }
    }

}
