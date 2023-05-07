package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Baekjoon_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            String s= br.readLine();
            st = new StringTokenizer(s, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x,y);
        }
        Arrays.sort(points);

        for (int i = 0; i < n; i++) {
            System.out.println(points[i].x + " " + points[i].y);
        }

    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Point o) {
            if(o.x == this.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
