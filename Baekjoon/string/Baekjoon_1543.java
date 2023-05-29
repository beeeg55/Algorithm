package sort.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1543 {
    static int max;
    static int all_len;
    static int word_len;
    static String all;
    static String word;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        all = br.readLine();
        word = br.readLine();

        all_len = all.length();
        word_len = word.length();
        max = 0;
        if(all_len<word_len){
            System.out.println(0);
        }else{
            visit = new boolean[all_len-word_len+1];
            search(0,0);
            System.out.println(max);
        }

    }

    public static void search(int start, int count){
        if(start<all_len-word_len+1&&visit[start]){
            return;
        }
        if(start> all_len-word_len){
            if(count > max){
                max = count;
            }
            return;
        }
        if(all.substring(start,start+word_len).equals(word)){
            search(start + word_len, count + 1);
        }

        search(start+1,count);
        visit[start] = true;

    }
}
