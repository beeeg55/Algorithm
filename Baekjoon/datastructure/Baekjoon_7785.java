package sort.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            String inout = st.nextToken();
            if(inout.equals("enter")){
                set.add(name);
            }else{
                set.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);

        for (int i = list.size()-1; i >= 0 ; i--) {
            System.out.println(list.get(i));
        }
    }
}
